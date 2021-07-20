<?php
defined('BASEPATH') OR exit('No direct script access allowed');

use chriskacerguis\RestServer\RestController;


class Booking extends RestController {
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
		$dataBooking = $this->Mapi->data_booking($idUser);
		if($dataBooking->num_rows() !=0 ){
			$data = [
				'status' => 'berhasil',
				'result' => $dataBooking->result_array(),
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

	/*Booking untuk one trip */
	public function simpan_post()
	{
		$idUser = $this->post('id_user');
		$idPaket = $this->post('id_paket');
		$tanggalWisata = date("Y-m-d", strtotime($this->post('tanggal_wisata')));
		$peserta = $this->post('jumlah_peserta');

		$cekValidasi = $this->Mapi->data_akun2($idUser);
		if($cekValidasi->num_rows() !=0 ){
			//mendapatkan data harga
			$harga = $this->Mapi->data_harga_paket($idPaket,$peserta);
			if($harga->num_rows()!= 0){
				$hargaPaket = $harga->row()->harga_standar;
				$tanggalNow = date("Y-m-d");
				$kodeBooking = $this->generateRandomString();
				$totalHarga = $hargaPaket * $peserta;
				$dataBooking = [
					'id_user' => $idUser,
					'id_paket' => $idPaket,
					'kode_booking' => $kodeBooking,
					'tanggal_wisata' => $tanggalWisata,
					'tanggal_dibuat' => $tanggalNow,
					'jumlah_peserta' => $peserta,
					'status' => 2,
					'total_harga' => $totalHarga
				];
				$this->Mapi->simpan_booking($dataBooking);
				$data = [
					'status' => 'berhasil',
					'total_harga' => $totalHarga,
					'message' => 'Data berhasil disimpan!'
				];
				$this->response($data, 200);
			}else{
				$this->response([
					'status' => 'failed',
					'message' => 'Paket tidak tersedia!'
				], 404);
			}
		} else {
			$this->response([
				'status' => 'failed',
				'message' => 'User tidak ditemukan!'
			], 404);
		}
	}

	private function generateRandomString($length = 10) {
		return substr(str_shuffle(str_repeat($x='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ', ceil($length/strlen($x)) )),1,$length);
	}


}
