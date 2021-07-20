<?php
defined('BASEPATH') OR exit('No direct script access allowed');

use chriskacerguis\RestServer\RestController;


class User extends RestController {
	public $Mapi;

	function __construct()
	{
		// Construct the parent class
		parent::__construct();
		$this->load->model('Mapi');
	}

	public function akun_get($id = null)
	{
		if(!empty($id)){
			$token = $this->GET('token');
			$dataAkun =  $this->Mapi->data_akun($id,$token);
			if($dataAkun->num_rows() !=0 ){
				foreach($dataAkun->result_array() as $row){
					$data['email'] =$row['email'];
					$data['nama_lengkap'] =$row['nama_lengkap'];
					$data['no_ktp'] =$row['no_ktp'];
					$data['alamat'] =$row['alamat'];
					$data['no_telp'] =$row['no_telp'];
				};
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

	public function akun_put($id){
		$namaLengkap = $this->put('nama_lengkap');
		$noTelp = $this->put('no_telp');
		$noKtp = $this->put('no_ktp');
		$alamat = $this->put('alamat');
		$password = $this->put('password');
		$token = $this->put('token');
		$dataAkun =  $this->Mapi->data_akun($id,$token);
		if($dataAkun->num_rows() !=0 ){
			if($password != 0){
				$dataDetail =[
					'nama_lengkap' => $namaLengkap,
					'no_telp' => $noTelp,
					'alamat' => $alamat,
					'no_ktp' => $noKtp
				];
				$dataUser = [
					'password' => sha1($password)
				];
				$this->Mapi->update_password($dataUser,$id);
			} else {
				$dataDetail =[
					'nama_lengkap' => $namaLengkap,
					'no_telp' => $noTelp,
					'alamat' => $alamat,
					'no_ktp' => $noKtp
				];
			}
			$update = $this->Mapi->update_detail_user($dataDetail,$id);
			if ($update) {
				$data = [
					'status' => 'berhasil',
					'message' => 'Data berhasil diperbaharui'
				];
				$this->response($data, 200);
			} else {
				$this->response([
					'status' => 'gagal',
					'message' => 'Gagal menyimpan ke dalam server!'
				], 404);
			}

		}else{
			$this->response([
				'status' => 'gagal',
				'message' => 'User tidak ditemukan , error!'
			], 404);
		}

	}
}
