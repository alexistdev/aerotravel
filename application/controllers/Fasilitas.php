<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Class : Member (MemberController)
 * Login class to control to authenticate user credentials and starts user's session.
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Fasilitas extends CI_Controller
{

	public $session;
	public $form_validation;
	public $admin;
	public $upload;
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
		$data['dataTransaksi'] = $this->admin->get_data_transaksi();
		$view ='v_fasilitas';
		$this->_layout($data,$view);
	}

}
