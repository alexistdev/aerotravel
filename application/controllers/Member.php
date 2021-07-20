<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Class : Member (MemberController)
 * Login class to control to authenticate user credentials and starts user's session.
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Member extends CI_Controller {

	public $session;

	public function __construct()
	{
		parent::__construct();
		$this->load->model('m_admin', 'admin');
		if ($this->session->userdata('is_login_in') !== TRUE) {
			redirect('login');
		}
	}

	private function _layout($data, $view)
	{
		$this->load->view('view/' . $view, $data);
	}

	public function index()
	{
		$data['title'] = _myJudul();
		$view ='v_member';
		$this->_layout($data,$view);
	}

	public function logout()
	{
		$this->session->sess_destroy();
		redirect('Login');
	}
}
