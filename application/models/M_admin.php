<?php
defined('BASEPATH') or exit('No direct script access allowed');

class M_admin extends CI_Model
{
	public function __construct()
	{
		parent::__construct();
		$this->load->database();
		$this->tbadmin = 'admin';
		$this->tbuser = 'user';
		$this->tbdetailuser = 'detail_user';
		$this->tbFasilitas = 'fasilitas_include';
		$this->tbDestinasi = 'destinasi';
		$this->tbJadwal = 'jadwal';
		$this->tbInbox = 'inbox';
		$this->tbBalas = 'inboxbalas';
	}

	####################################################################################
	#                              Tabel Inbox                                         #
	####################################################################################
	public function get_data_inbox()
	{
		$this->db->join($this->tbdetailuser, "$this->tbdetailuser.id_user = $this->tbInbox.id_user");
		$this->db->order_by("$this->tbInbox.status_pesan", "ASC");
		$this->db->order_by("$this->tbInbox.id_inbox", "DESC");
		return $this->db->get($this->tbInbox);
	}

	public function get_data_inboxbytoken($data)
	{
		$this->db->where("$this->tbBalas.key_token",$data);
		$this->db->order_by("$this->tbBalas.id_balas", "DESC");
		return $this->db->get($this->tbBalas);
	}

	public function simpan_balas($data)
	{
		$this->db->insert($this->tbBalas,$data);
	}

	public function perbaharui_inbox($dataInbox, $key)
	{
		$this->db->where('key_token',$id);
		$this->db->update($this->tbInbox,$dataInbox);
	}

	####################################################################################
	#                              Tabel Jadwal                                        #
	####################################################################################
	public function get_data_jadwal($id, $tipe)
	{
		$this->db->join($this->tbDestinasi, "$this->tbDestinasi.id_destinasi = $this->tbJadwal.id_destinasi");
		$this->db->where("$this->tbJadwal.id_destinasi", $id);
		$this->db->where('type', $tipe);
		//$this->db->order_by('id_jadwal', "DESC");
		return $this->db->get($this->tbJadwal);
	}

	public function simpan_jadwal($data)
	{
		$this->db->insert($this->tbJadwal,$data);
	}

	public function get_data_byidjadwal($id)
	{
		$this->db->where("$this->tbJadwal.id_jadwal", $id);
		return $this->db->get($this->tbJadwal);
	}

	public function hapus_jadwal($id)
	{
		$this->db->where("$this->tbJadwal.id_jadwal", $id);
		$this->db->delete($this->tbJadwal);
	}


	####################################################################################
	#                              Tabel Fasilitas                                     #
	####################################################################################
	public function get_data_fasilitas($id, $tipe)
	{
		$this->db->join($this->tbDestinasi, "$this->tbDestinasi.id_destinasi = $this->tbFasilitas.id_destinasi");
		$this->db->where("$this->tbFasilitas.id_destinasi", $id);
		$this->db->where('type', $tipe);
		$this->db->order_by('id_fasilitas', "DESC");
		return $this->db->get($this->tbFasilitas);
	}

	public function get_data_byidfasilitas($id)
	{
		$this->db->where("$this->tbFasilitas.id_fasilitas", $id);
		return $this->db->get($this->tbFasilitas);
	}

	public function hapus_fasilitas($id)
	{
		$this->db->where("$this->tbFasilitas.id_fasilitas", $id);
		$this->db->delete($this->tbFasilitas);
	}

	public function simpan_fasilitas($data)
	{
		$this->db->insert($this->tbFasilitas,$data);
	}


	####################################################################################
	#                              Tabel booking                                      #
	####################################################################################
	public function get_data_transaksi()
	{
		return $this->db->get("booking");
	}

	public function get_data_byidbooking($data)
	{
		$this->db->where('id_booking', $data);
		return $this->db->get("booking");
	}

	public function update_transaksi($dataTransaksi,$id)
	{
		$this->db->where('id_booking',$id);
		$this->db->update("booking",$dataTransaksi);
	}
	####################################################################################
	#                              Tabel destinasi                                     #
	####################################################################################
	public function get_data_destinasi($data)
	{
		return $this->db->get("destinasi");
	}

	public function get_data_byiddestinasi($data)
	{
		$this->db->where('id_destinasi', $data);
		return $this->db->get("destinasi");
	}

	public function simpan_destinasi($data)
	{
		$this->db->insert("destinasi",$data);
		return $this->db->insert_id();
	}

	public function update_destinasi($dataDestinasiGambar,$idDestinasi)
	{
		$this->db->where('id_destinasi',$idDestinasi);
		$this->db->update("destinasi",$dataDestinasiGambar);
	}

	public function hapus_destinasi($id)
	{
		$this->db->where('id_destinasi', $id);
		$this->db->delete("destinasi");
	}


	####################################################################################
	#                              Tabel user & detailuser                             #
	####################################################################################
	public function get_data_user($data=null){
		$this->db->join($this->tbdetailuser, 'detail_user.id_user=user.id_user');
		if($data != null){
			$this->db->where('user.id_user', $data);
		}
		return $this->db->get($this->tbuser);
	}
	public function update_user($data,$id)
	{
		$this->db->where('id_user',$id);
		$this->db->update($this->tbuser,$data);
	}
	public function update_detail($data,$id)
	{
		$this->db->where('id_user',$id);
		$this->db->update($this->tbdetailuser,$data);
	}
	public function simpan_user($data)
	{
		$this->db->insert($this->tbuser,$data);
		return $this->db->insert_id();
	}
	/** Menyimpan data detail user */
	public function simpan_detail_user($data)
	{
		$this->db->insert($this->tbdetailuser,$data);
	}

	####################################################################################
	#                                  Tabel admin                                     #
	####################################################################################
	/** Dapat data untuk validasi login */
	public function validasi_login($username)
	{
		$this->db->where('username', $username);
		return $this->db->get($this->tbadmin);
	}

	public function update_admin($data)
	{
		$this->db->where('id_admin',1);
		$this->db->update($this->tbadmin,$data);
	}
}
