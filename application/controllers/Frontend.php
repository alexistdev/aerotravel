<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Class : Login (LoginController)
 * Login class to control to authenticate user credentials and starts user's session.
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Frontend extends CI_Controller {

	/**
	 * Halaman Index Untuk Controller.
	 */
	public function index()
	{
		$data['title'] = "MyTour | Paket Wisata Tour And Travel Terbaik di Lampung";
		$this->load->view('Frontend/v_frontend', $data);
	}

}
