<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
 * Class : Setting (Setting Controller)
 * Kelas untuk menangani halaman setting
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Setting extends CI_Controller
{
	public $session;
	public $form_validation;
	public $input;
	public $admin;


	public function __construct()
	{
		parent::__construct();
		$this->load->model('m_admin', 'admin');
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
		$this->form_validation->set_rules(
			'password1',
			'Password',
			'trim|min_length[4]|max_length[16]|required',
			[
				'max_length' => 'Panjang karakter Password maksimal 16 karakter!',
				'min_length' => 'Panjang karakter Password minimal 6 karakter!',
				'required' => 'Password harus diisi!'
			]
		);
		$this->form_validation->set_rules(
			'password2',
			'Password',
			'trim|matches[password1]|required',
			[
				'required' => 'Password harus diisi!',
				'matches' => 'Password tidak sama!'
			]
		);
		$this->form_validation->set_error_delimiters('<div class="alert alert-danger" role="alert">', '</div>');
		if ($this->form_validation->run() === false) {
			$this->session->set_flashdata('pesan', validation_errors());
			$data['title'] = _myJudul();
			$view = 'v_setting';
			$this->_layout($data, $view);
		}else{
			$password = $this->input->post("password1", TRUE);
			$inPass = password_hash($password,PASSWORD_BCRYPT);
			$dataAdmin = [
				'password' => $inPass
			];
			$this->admin->update_admin($dataAdmin);
			$this->session->set_flashdata('pesan2', '<div class="alert alert-success" role="alert">Berhasil Memperbaharui data!</div>');
			redirect('Setting');
		}
	}
}
