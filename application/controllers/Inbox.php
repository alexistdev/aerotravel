<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Class : Masteruser (Masteruser Controller)
 * Kelas untuk menanganti halaman Master Data/ User
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Inbox extends CI_Controller {

	public $admin;
	public $load;
	public $session;
	public $form_validation;
	public $input;

	public function __construct()
	{
		parent::__construct();
		$this->load->model('M_admin', 'admin');
		if ($this->session->userdata('is_login_in') !== TRUE) {
			redirect('Login');
		}
	}

	private function _layout($data, $view)
	{
		$this->load->view('view/' . $view, $data);
	}

	public function index()
	{
		$data['title'] = _myJudul();
		$data['dataInbox'] = $this->admin->get_data_inbox();
		$view ='v_inbox';
		$this->_layout($data,$view);
	}

	public function detail($key=null)
	{
		if($key=='' || $key == null){
			redirect('Inbox');
		}else {
			$getData = $this->admin->get_data_inboxbytoken($key);
			if($getData->num_rows() != 0){
				$this->form_validation->set_rules(
					'pesan',
					'Pesan',
					'trim|min_length[3]|max_length[300]|required',
					[
						'max_length' => 'Panjang karakter Pesan maksimal 300 karakter!',
						'min_length' => 'Panjang karakter Pesan minimal 3karakter!',
						'required' => 'Pesan harus diisi!'
					]
				);
				$this->form_validation->set_error_delimiters('<div class="alert alert-danger" role="alert">', '</div>');
				if ($this->form_validation->run() === false) {
					$this->session->set_flashdata('pesan', validation_errors());
					$data['title'] = _myJudul();
					$data['dataDetailInbox'] = $getData->result_array();
					$data['token'] = $key;
					$view = 'v_detailinbox';
					$this->_layout($data, $view);
				}else{
					$pesan = $this->input->post("pesan", TRUE);
					$dataBalas = [
						'is_admin' => 2,
						'key_token' => $key,
						'pesan' => $pesan,
						'time' => date("Y-m-d")
					];
					$this->admin->simpan_balas($dataBalas);

					$dataInbox = [
						'status_pesan' => 2
					];
					$this->admin->perbaharui_inbox($dataInbox, $key);
					$this->session->set_flashdata('pesan2', '<div class="alert alert-success" role="alert">Berhasil Membalas Pesan!</div>');
					redirect('Inbox/detail/'.$key);
				}
			} else {
				redirect('Inbox');
			}
		}
	}

}
