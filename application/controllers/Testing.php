<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
 * Class : Setting (Setting Controller)
 * Kelas untuk menangani halaman setting
 * @author : Calysta sakralya althasya (1711010041)
 * @version : 1.0
 * @develop : 18 Desember 2020
 */

class Testing extends CI_Controller
{
	public $session;
	public $form_validation;
	public $input;
	public $admin;


	public function __construct()
	{
		parent::__construct();

	}

	private function _layout($data, $view)
	{
		$this->load->view('view/' . $view, $data);
	}

	public function index()
	{
		echo "da";
	}

	public function oke($id =NULL)
	{
		echo $id;
	}
}
