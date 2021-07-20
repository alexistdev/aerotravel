<?php
defined('BASEPATH') OR exit('No direct script access allowed');

use chriskacerguis\RestServer\RestController;


class Fasilitas extends RestController
{
	public $Mapi;

	function __construct()
	{
		// Construct the parent class
		parent::__construct();
		$this->load->model('Mapi');
	}

	public function include_get($idDestinasi = NULL)
	{
		if (!empty($idDestinasi)) {
			/* tipe ini adalah 1 hari atau 2 hari */
			$type = $this->GET('type');
			$dataDestinasi =  $this->Mapi->data_fasilitas_include($idDestinasi,$type);
			if($dataDestinasi->num_rows() !=0 ){
				$data = [
					'status' => 'berhasil',
					'result' => $dataDestinasi->result_array(),
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
		} else {
			$this->response([
				'status' => 'gagal',
				'result' => [],
				'message' => 'id tidak ditemukan , error!'
			], 404);
		}
	}

}
