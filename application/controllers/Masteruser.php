<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Class : Masteruser (Masteruser Controller)
 * Kelas untuk menanganti halaman Master Data/ User
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Masteruser extends CI_Controller {
	public $user;
	public $session;
	public $form_validation;
	public $input;


	public function __construct()
	{
		parent::__construct();
		$this->load->model('M_user', 'user');
		//is_logged_in();
	}

	/**
	 * Halaman Index Untuk Controller.
	 */
	public function index()
	{
		$data['title'] = "Dashboard MyTour | Paket Wisata Tour And Travel Terbaik di Lampung";
		$data['dataUser'] = $this->user->getData()->result_array();
		$view = 'v_datauser';
		$this->_template($data, $view);
	}

	private function _template($data, $view)
	{
		$this->load->view('Member/' . $view, $data);
	}

	/**
	 * Method untuk menambahkan data user.
	 */

	public function tambah()
	{
		$this->form_validation->set_rules(
            'namaLengkap',
            'Nama Lengkap',
            'trim|required|min_length[4]',
            [
                'required' => 'Nama Lengkap harus diisi!',
                'min_length' => 'Panjang karakter Nama minimal 4 karakter!'
            ]
        );
		$this->form_validation->set_rules(
			'nomorTelepon',
			'Nomor Telepon',
			'trim|max_length[30]',
			[
				'max_length' => 'Panjang karakter maksimal 30 karakter!'
			]
		);
		$this->form_validation->set_rules(
			'email',
			'Email User',
			'trim|required',
			[
				'required' => 'Email harus diisi!'
			]
		);
		$this->form_validation->set_error_delimiters('<div class="alert alert-danger" role="alert">', '</div>');
		if ($this->form_validation->run() == false) {
			$this->session->set_flashdata('pesan', validation_errors());
			$this->index();
		} else {
			$namaLengkap = $this->input->post('namaLengkap', TRUE);
			$emailUser = $this->input->post('email', TRUE);
			$nomorTelepon = $this->input->post('nomorTelepon', TRUE);
			$password = md5("123456789");
			//simpan ke dalam tabel user
			$dataUser = [
				'email' => $emailUser,
				'password' => $password,
				'type' => 3
			];
			$idUser = $this->user->simpan_data_user($dataUser);
			//menyimpan ke dalam tabel detail_user
			$dataDetailUser = [
				'id_user' => $idUser,
				'nama_lengkap' => $namaLengkap,
				'no_telp' => $nomorTelepon
			];
			$this->user->simpan_detail_user($dataDetailUser);
			$this->session->set_flashdata('pesan2', '<div class="alert alert-success" role="alert">Pesan berhasil dibuat!</div>');
			redirect('Masteruser');
		}
	}

	/**
	 * Method menampilkan detail user.
	 */

	public function detail($idUserx=NULL){
		$idUser = decrypt_url($idUserx);
		if(($idUserx == NULL) || ($idUserx = '')){
			redirect('Masteruser');
		} else {
			$cekIdUser = $this->user->cek_id_user($idUser);
			if($cekIdUser != 0){
				$data['title'] = "Detail User MyTour | Paket Wisata Tour And Travel Terbaik di Lampung";
				$data['namaUser'] = $this->user->getDetailInfo($idUser)->nama_lengkap;
				$data['emailUser'] = $this->user->getDetailInfo($idUser)->email;
				$data['telpUser'] = $this->user->getDetailInfo($idUser)->no_telp;
				$data['alamatUser'] = $this->user->getDetailInfo($idUser)->alamat;
				$data['noKtp'] = $this->user->getDetailInfo($idUser)->no_ktp;
				$data['idUser'] = $idUser;
				$view = 'v_detail_user';
				$this->_template($data, $view);
			} else {
				redirect('Masteruser');
			}
		}
	}

	/**
	 * Method untuk mengupdate data user.
	 */

	public function update(){
		$this->form_validation->set_rules(
			'NamaLengkap',
			'Nama Lengkap',
			'trim|required|min_length[4]|max_length[80]',
			[
				'required' => 'Nama Lengkap harus diisi!',
				'min_length' => 'Panjang karakter Nama minimal 4 karakter!',
				'max_length' => 'Panjang karakter Nama maksimal 80 karakter!'
			]
		);
		$this->form_validation->set_rules(
			'passBaru',
			'Password Baru',
			'trim|max_length[80]',
			[
				'max_length' => 'Panjang karakter Password maksimal 30 karakter!'
			]
		);
		$this->form_validation->set_rules(
			'NomorTelepon',
			'Nomor Telepon',
			'trim|max_length[30]',
			[
				'max_length' => 'Panjang karakter Nama minimal 30 karakter!'
			]
		);
		$this->form_validation->set_rules(
			'NomorKtp',
			'Nomor KTP',
			'trim|max_length[50]',
			[
				'max_length' => 'Panjang karakter Nama minimal 50 karakter!'
			]
		);
		$this->form_validation->set_rules(
			'alamat',
			'Alamat',
			'trim|max_length[300]',
			[
				'max_length' => 'Panjang karakter Nama minimal 300 karakter!'
			]
		);
		$idUser = $this->input->post('idUser', TRUE);
		$this->form_validation->set_error_delimiters('<div class="alert alert-danger" role="alert">', '</div>');
		if ($this->form_validation->run() == false) {
			$this->session->set_flashdata('pesan', validation_errors());
			redirect('Masteruser/detail/'.$idUser.'#settings');
		} else {
			$password = $this->input->post('passBaru', TRUE);
			$namaLengkap = $this->input->post('NamaLengkap', TRUE);
			$noTelp = $this->input->post('NomorTelepon', TRUE);
			$ktp = $this->input->post('NomorKtp', TRUE);
			$alamat = $this->input->post('alamat', TRUE);

			// Memasukkan data untuk diupdate di tabel detail_user
			$dataDetail = [
				'nama_lengkap' => $namaLengkap,
				'no_ktp' => $ktp,
				'alamat' => $alamat,
				'no_telp' =>$noTelp
			];
			$this->user->detail_user_update ($dataDetail,$idUser);
			//jika password kosong maka password tidak diperbaharui
			if($password != ""){
				$dataUser = [
					'password' => md5($password)
				];
				$this->user->user_update ($dataUser,$idUser);
			}
			//redirect jika berhasil
			$this->session->set_flashdata('pesan2', '<div class="alert alert-success" role="alert">Data berhasil diperbaharui!</div>');
			redirect('Masteruser/detail/'.$idUser.'#settings');
		}
	}

	/**
	 * Method untuk menghapus data user.
	 */

	public function hapus($idUser=NULL)
	{
		$idUser = decrypt_url($idUser);
		//mengecek apakah idUser ada;
		$cekUser = $this->user->cek_id_user($idUser);
		if($cekUser != 0){
			$this->user->hapus_user($idUser);
			$this->session->set_flashdata('pesan2', '<div class="alert alert-danger" role="alert">Data berhasil dihapus!</div>');
			redirect('Masteruser');
		} else {
			redirect('Masteruser');
		}
	}
}
