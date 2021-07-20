<?php
defined('BASEPATH') OR exit('No direct script access allowed');

use chriskacerguis\RestServer\RestController;


class Inbox extends RestController
{
	public $Mapi;

	function __construct()
	{
		// Construct the parent class
		parent::__construct();
		$this->load->model('Mapi');
	}

	public function tampil_post()
	{
		$idUser = $this->post('id_user');
		$dataInbox = $this->Mapi->data_inbox($idUser);
		if($dataInbox->num_rows() !=0 ){
			$data = [
				'status' => 'berhasil',
				'result' => $dataInbox->result_array(),
				'message' => 'Data berhasil didapatkan'
			];
			$this->response($data, 200);
		} else {
			$this->response([
				'status' => 'gagal',
				'result' => [],
				'message' => 'data kosong!'
			], 404);
		}
	}

	public function tambah_post()
	{
		$idUser = $this->post('id_user');
		$judul = $this->post('judul');
		$pesan = $this->post('pesan');
		$cekValidasi = $this->Mapi->data_akun2($idUser);
		if($cekValidasi->num_rows() !=0 ){
			$kodeToken = kodegenerator(20);
			/** menyimpan ke dalam tabel inbox */
				$dataInbox = [
					'id_user' => $idUser,
					'is_adm' => 0,
					'judul' => $judul,
					'pesan' => $pesan,
					'key_token' => $kodeToken,
					'time' => date("Y-m-d"),
					'status_pesan' => 1
				];
			/** menyimpan ke dalam tabel inboxbalas */
				$dataBalas = [
					'is_admin' => 1,
					'key_token' => $kodeToken,
					'pesan' => $pesan,
					'time' => date("Y-m-d")
				];
				$this->Mapi->simpan_inbox($dataInbox);
				$this->Mapi->simpan_balas($dataBalas);
				$data = [
					'status' => 'berhasil',
					'message' => 'Data berhasil disimpan'
				];
				$this->response($data, 200);
		} else {
			$this->response([
				'status' => 'failed',
				'message' => 'User tidak ditemukan!'
			], 404);
		}
	}

	public function detail_get(){
		$keyToken = $this->get('key_token');
		$dataDetail = $this->Mapi->get_data_detailpesan($keyToken);
		if($dataDetail->num_rows() !=0 ){
			$data = [
				'result' => $dataDetail->result_array(),
				'message' => 'Data berhasil didapatkan'
			];
			$this->response($data, 200);
		} else {
			$this->response([
				'status' => 'gagal',
				'result' => [],
				'message' => 'data kosong!'
			], 404);
		}
	}

	public function balas_post(){
		$keyToken = $this->post('key_token');
		$pesan = $this->post('pesan');
		$dataBalas = [
			'is_admin' => 1,
			'key_token' => $keyToken,
			'pesan' => $pesan,
			'time' => date("Y-m-d")
		];
		$this->Mapi->simpan_balas($dataBalas);
		$data = [
			'status' => 'berhasil',
			'message' => 'Data berhasil disimpan'
		];
		$this->response($data, 200);
	}
}
