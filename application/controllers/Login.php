<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Login extends CI_Controller {
	public $session;
	public $form_validation;
	public $input;
	public $login;

	/** Constructor dari Class Login */
	public function __construct()
	{
		parent::__construct();
		$this->load->model('m_admin', 'login');
		if ($this->session->userdata('is_login_in') == TRUE) {
			redirect('Member');
		}
	}

	/** Template untuk memanggil view */
	private function _layout($data, $view)
	{
		$this->load->view('view/' . $view, $data);
	}

	/** Method untuk generate captcha */
	private function _create_captcha()
	{
		$cap = create_captcha(config_captcha());
		$image = $cap['image'];
		$this->session->set_userdata('captchaword', $cap['word']);
		return $image;
	}

	/** Validasi Captcha */
	public function _check_captcha($string)
	{
		if ($string == $this->session->userdata('captchaword')) {
			return TRUE;
		} else {
			$this->form_validation->set_message('_check_captcha', 'Captcha yang anda masukkan salah!');
			return FALSE;
		}
	}

	/** Menampilkan halaman default login, dengan form validation */
	public function index()
	{
		$this->form_validation->set_rules(
			'username',
			'Username',
			'trim|required',
			[
				'required' => 'Username harus diisi!'
			]
		);
		$this->form_validation->set_rules(
			'password',
			'Password',
			'trim|required',
			[
				'required' => 'Password harus diisi!'
			]
		);
		$this->form_validation->set_rules(
			'captcha',
			'Captcha',
			'trim|callback__check_captcha|required',
			[
				'required' => 'Captcha harus diisi!'
			]
		);
		$this->form_validation->set_error_delimiters('<div class="alert alert-danger" role="alert">', '</div>');
		if ($this->form_validation->run() === false) {
			$this->session->set_flashdata('pesan', validation_errors());
			$data['image'] = $this->_create_captcha();
			$data['title'] = _myJudul();
			$view ='v_login';
			$this->_layout($data,$view);
		} else {
			$username = $this->input->post('username', TRUE);
			$password = $this->input->post('password', TRUE);
			$cekLogin = $this->login->validasi_login($username)->row();

			if(!password_verify($password, $cekLogin->password)){
				$this->session->set_flashdata('pesan2', '<div class="alert alert-danger" role="alert">Username atau password anda salah!</div>');
				redirect("Login");
			} else {

				$data_session = [
					'is_login_in' => TRUE
				];
				$this->session->set_userdata($data_session);
				redirect("Member");
			}
		}
	}
}
