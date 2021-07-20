<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Class : Login (LoginController)
 * Login class to control to authenticate user credentials and starts user's session.
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Auth extends CI_Controller {

	/**
	 * Default constructor dari kelas
	 */
	public function __construct()
	{
		parent::__construct();
		$this->load->model('login_model');
	}

	/**
	 * Method index dari controller
	 */
	public function index()
	{
		$this->_isLoggedIn();
	}

	/**
	 * Mengecek fungsi status login dengan session
	 */
	private function _isLoggedIn()
	{
		$isLoggedIn = $this->session->userdata('isLoggedIn');

		if(!isset($isLoggedIn) || $isLoggedIn != TRUE)
		{
			$data['title'] = "MyTour | Log in";
			$this->load->view('Auth/Login', $data);
		}
		else
		{
			redirect('/admin');
		}
	}
}
