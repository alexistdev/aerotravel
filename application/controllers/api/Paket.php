<?php
defined('BASEPATH') OR exit('No direct script access allowed');

use chriskacerguis\RestServer\RestController;


class Paket extends RestController
{
	public $Mapi;

	public function __construct()
	{
		// Construct the parent class
		parent::__construct();
		$this->load->model('Mapi');
	}

	public function tampil_get()
	{
		$kategori = $this->GET('kategori');
		$dataPaket = $this->Mapi->data_paket($kategori);
		if($dataPaket->num_rows() !=0 ){
			$data = [
				'status' => 'berhasil',
				'result' => $dataPaket->result_array(),
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

	public function harga_get()
	{
		$idPaket = $this->GET('id_paket');
		$dataHarga = $this->Mapi->data_harga($idPaket);
		if($dataHarga->num_rows() !=0 ){
			$data = [
				'status' => 'berhasil',
				'result' => $dataHarga->result_array(),
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
}
