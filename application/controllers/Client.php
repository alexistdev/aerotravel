<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
 * Class : Setting (Setting Controller)
 * Kelas untuk menangani halaman setting
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Client extends CI_Controller
{
	public $session;
	public $admin;
	public $form_validation;
	public $input;

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
		$data['title'] = _myJudul();
		$data['dataUser'] = $this->admin->get_data_user()->result_array();
		$view = 'v_client';
		$this->_layout($data, $view);
	}

	public function tambah()
	{
		$this->form_validation->set_rules(
			'namaLengkap',
			'Nama Lengkap',
			'trim|min_length[3]|required',
			[
				'min_length' => 'Panjang karakter Nama Lengkap minimal 3 karakter!',
				'required' => 'Nama Lengkap harus diisi !'
			]
		);
		$this->form_validation->set_rules(
			'email',
			'Email',
			'trim|max_length[128]|valid_email|is_unique[user.email]|required',
			[
				'max_length' => 'Panjang karakter Email maksimal 128 karakter!',
				'is_unique' => 'Email sudah pernah digunakan',
				'valid_email' => 'Email yang anda masukkan tidak valid',
				'required' => 'Email harus diisi!'
			]
		);
		$this->form_validation->set_rules(
			'notelp',
			'Nomor Telepon',
			'trim|min_length[3]',
			[
				'min_length' => 'Panjang karakter Nomor Telepon minimal 3 karakter!',
				'required' => 'Nomor Telepon harus diisi !'
			]
		);
		$this->form_validation->set_rules(
			'noKtp',
			'Nomor KTP',
			'trim|min_length[5]',
			[
				'min_length' => 'Panjang karakter Nomor KTP minimal 5 karakter!',
				'required' => 'Nomor Telepon harus diisi !'
			]
		);
		$this->form_validation->set_rules(
			'alamat',
			'Alamat',
			'trim|min_length[5]|max_length[128]',
			[
				'max_length' => 'Panjang karakter Email maksimal 128 karakter!',
				'min_length' => 'Panjang karakter Nomor KTP minimal 5 karakter!',
				'required' => 'Nomor Telepon harus diisi !'
			]
		);
		$this->form_validation->set_error_delimiters('<div class="alert alert-danger" role="alert">', '</div>');
		if ($this->form_validation->run() === false) {
			$this->session->set_flashdata('pesan', validation_errors());
			$data['title'] = _myJudul();
			$view = 'v_tambahclient';
			$this->_layout($data, $view);
		} else {
			$namaLengkap = $this->input->post("namaLengkap", TRUE);
			$email = $this->input->post("email", TRUE);
			$notelp = $this->input->post("notelp", TRUE);
			$noKtp = $this->input->post("noKtp", TRUE);
			$alamat = $this->input->post("alamat", TRUE);
			$password = $this->input->post("password", TRUE);

			$dataUser = [
				'password' => sha1($password),
				'email' => $email,
				'status' => 1
			];
			$idUser = $this->admin->simpan_user($dataUser);
			$dataDetail = [
				'id_user' => $idUser,
				'nama_lengkap' => $namaLengkap,
				'no_ktp' => $noKtp,
				'alamat' => $alamat,
				'no_telp' => $notelp
			];
			$this->admin->simpan_detail_user($dataDetail);
			$this->session->set_flashdata('pesan2', '<div class="alert alert-success" role="alert">Berhasil Menambah data!</div>');
			redirect('Client');
		}
	}

	public function edit($idx=null)
	{
		$id = decrypt_url($idx);
		if($idx==null || $idx == '' || $id==''){
			redirect('Client');
		} else {
			$cekId = $this->admin->get_data_user($id)->num_rows();
			if($cekId !=0){
				$this->form_validation->set_rules(
					'namaLengkap',
					'Nama Lengkap',
					'trim|min_length[3]|required',
					[
						'min_length' => 'Panjang karakter Nama Lengkap minimal 3 karakter!',
						'required' => 'Nama Lengkap harus diisi !'
					]
				);
				$this->form_validation->set_rules(
					'email',
					'Email',
					'trim|max_length[128]|valid_email|required',
					[
						'max_length' => 'Panjang karakter Email maksimal 128 karakter!',
						'valid_email' => 'Email yang anda masukkan tidak valid',
						'required' => 'Email harus diisi!'
					]
				);
				$this->form_validation->set_rules(
					'notelp',
					'Nomor Telepon',
					'trim|min_length[3]',
					[
						'min_length' => 'Panjang karakter Nomor Telepon minimal 3 karakter!',
						'required' => 'Nomor Telepon harus diisi !'
					]
				);
				$this->form_validation->set_rules(
					'noKtp',
					'Nomor KTP',
					'trim|min_length[5]',
					[
						'min_length' => 'Panjang karakter Nomor KTP minimal 5 karakter!',
						'required' => 'Nomor Telepon harus diisi !'
					]
				);
				$this->form_validation->set_rules(
					'alamat',
					'Alamat',
					'trim|min_length[5]|max_length[128]',
					[
						'max_length' => 'Panjang karakter Email maksimal 128 karakter!',
						'min_length' => 'Panjang karakter Nomor KTP minimal 5 karakter!',
						'required' => 'Nomor Telepon harus diisi !'
					]
				);
				$this->form_validation->set_error_delimiters('<div class="alert alert-danger" role="alert">', '</div>');
				if ($this->form_validation->run() === false) {
					$this->session->set_flashdata('pesan', validation_errors());
					$data = $this->_preparedata($id);
					$judul['title'] = _myJudul();
					$data = array_merge($data, $judul);
					$view = 'v_editclient';
					$this->_layout($data, $view);
				} else {
					$namaLengkap = $this->input->post("namaLengkap", TRUE);
					$email = $this->input->post("email", TRUE);
					$notelp = $this->input->post("notelp", TRUE);
					$noKtp = $this->input->post("noKtp", TRUE);
					$alamat = $this->input->post("alamat", TRUE);
					$password = $this->input->post("password", TRUE);
					if($password != ''){
						$dataUser = [
							'password' => sha1($password),
							'email' => $email
						];
					}else {
						$dataUser = [
							'email' => $email
						];
					}
					$dataDetail = [
						'nama_lengkap' => $namaLengkap,
						'no_ktp' => $noKtp,
						'alamat' => $alamat,
						'no_telp' => $notelp
					];
					$this->admin->update_user($dataUser,$id);
					$this->admin->update_detail($dataDetail,$id);
					$this->session->set_flashdata('pesan2', '<div class="alert alert-success" role="alert">Berhasil Memperbaharui data!</div>');
					redirect('Client/edit/'.encrypt_url($id));
				}
			}else{
				redirect('Client');
			}
		}
	}

	private function _preparedata($id)
	{
		$data=[];
		$detailUser = $this->admin->get_data_user($id)->result_array();
		foreach($detailUser as $rowUser){
			$data['namaUser'] = $rowUser['nama_lengkap'];
			$data['ktp'] = $rowUser['no_ktp'];
			$data['idUser'] = $rowUser['id_user'];
			$data['alamat'] = $rowUser['alamat'];
			$data['telp'] = $rowUser['no_telp'];
			$data['email'] = $rowUser['email'];
		}
		return $data;
	}
}
