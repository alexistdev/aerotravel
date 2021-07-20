<?php
defined('BASEPATH') or exit('No direct script access allowed');

class M_api extends CI_Model
{

	public function __construct()
	{
		parent::__construct();
		$this->load->database();
		$this->tbDestinasi = 'destinasi';
		$this->tbuser = 'user';
		$this->tbdetailuser = 'detail_user';
	}



	/**
	 * ==========================================================================
	 * Table Destinasi
	 * ==========================================================================
	 */

	/* Menampilkan destinasi */
	public function data_tampil_destinasi(){
		return $this->db->get($this->tbDestinasi);
	}

	/**
	 * ==========================================================================
	 * Table user dan detail_user
	 * ==========================================================================
	 */

	public function cek_email($email)
	{
		$this->db->where('email',$email);
		return $this->db->get($this->tbuser);
	}
	public function simpan_user($data)
	{
		$this->db->insert($this->tbuser,$data);
		return $this->db->insert_id();
	}
	public function simpan_detail_user($data)
	{
		$this->db->insert($this->tbdetailuser,$data);
	}

	public function cek_login($email, $password)
	{
		$this->db->where('email', $email);
		$this->db->where('password', $password);
		return $this->db->get($this->tbuser);
	}

	/** Data login */
	public function data_user($email)
	{
		$this->db->where('email', $email);
		return $this->db->get($this->tbuser);
	}
	public function simpan_token($data,$email)
	{
		$this->db->where('email',$email);
		$this->db->update($this->tbuser,$data);
	}




}
