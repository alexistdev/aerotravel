<?php
defined('BASEPATH') or exit('No direct script access allowed');
?>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Edit Client <span class="text-primary font-weight-bold"><?= ucwords(sanitasi($namaUser)); ?></span></h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<?= base_url('Member') ?>">Home</a></li>
						<li class="breadcrumb-item"><a href="<?= base_url('Client'); ?>">Client</a></li>
						<li class="breadcrumb-item active">Edit</li>
					</ol>
				</div>
			</div>
		</div><!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<?php
					echo $this->session->flashdata('pesan');
					echo $this->session->flashdata('pesan2'); ?>
				</div>
			</div>
			<form action="<?= base_url('Client/edit/'.encrypt_url($idUser)); ?>" method="post">
				<div class="row">
					<!--	Form Ruas Kiri		-->
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
								<!-- Nama Lengkap -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="namaLengkap">Nama Lengkap <span class="text-danger">*</span></label>
											<input type="text" name="namaLengkap" id="namaLengkap" maxlength="128" class="form-control" value="<?= ucwords(sanitasi($namaUser)); ?>" placeholder="Nama Lengkap" required="required">
										</div>
									</div>
								</div>
								<!-- Email -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="email">Email<span class="text-danger">*</span></label>
											<input type="email" name="email" id="email" maxlength="128" class="form-control" value="<?= sanitasi($email); ?>" placeholder="Email" required="required">
										</div>
									</div>
								</div>
								<!-- Password -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="password">Password </label>
											<input type="password" name="password" id="password" maxlength="16" class="form-control"  placeholder="******">
										</div>
									</div>
								</div>

								<!-- Nomor Telepon -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="notelp">Nomor Telepon</label>
											<input type="text" name="notelp" id="notelp" maxlength="30" class="form-control" value="<?= sanitasi($telp); ?>" placeholder="Nomor Telepon">
										</div>
									</div>
								</div>
								<!-- Nomor KTP -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="noKtp">Nomor KTP</label>
											<input type="text" name="noKtp" id="noKtp" maxlength="50" class="form-control" value="<?= sanitasi($ktp); ?>" placeholder="KTP">
										</div>
									</div>
								</div>
								<!-- Alamat-->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="alamat">Alamat</label>
											<textarea name="alamat" id="alamat" class="form-control" placeholder="Alamat Lengkap"><?= sanitasi($alamat); ?></textarea>
										</div>
									</div>
								</div>
								<!-- Submit -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<button type="submit" class="btn btn-primary">Simpan</button>
											<a href="<?= base_url('Client'); ?>"><button type="button" class="btn btn-danger">Batal</button></a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>
</div>
<!-- /.content-wrapper -->
