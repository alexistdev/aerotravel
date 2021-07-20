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
					<h1>Tambah Data Destinasi</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<?= base_url('Member') ?>">Home</a></li>
						<li class="breadcrumb-item"><a href="<?= base_url('Destinasi'); ?>">Destinasi</a></li>
						<li class="breadcrumb-item active">Tambah</li>
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
					echo $this->session->flashdata('pesan2');
					echo $this->session->flashdata('pesan3');?>
				</div>
			</div>
			<form action="<?php echo base_url('Destinasi/tambah/');?>" method="post" enctype="multipart/form-data">
				<div class="row">
					<!--	Form Ruas Kiri		-->
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
								<!-- Kode Jurusan -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="judul">Judul <span class="text-danger">*</span></label>
											<input type="text" name="judul" id="judul" maxlength="50" class="form-control" value="<?= set_value('judul'); ?>" placeholder="Judul Destinasi" required="required">
										</div>
									</div>
								</div>
								<!-- Nama Jurusan -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="deskripsi">Deskripsi<span class="text-danger">*</span></label>
											<input type="text" name="deskripsi" id="deskripsi" maxlength="400" class="form-control" value="<?= set_value('deskripsi'); ?>" placeholder="Deskripsi" required="required">
										</div>
									</div>
								</div>
								<!-- Nama Jurusan -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="photo">Upload Gambar<span class="text-danger">*</span></label>
											<br>
											<?php for ($i=1; $i <=5 ; $i++) :?>
												<input type="file" name="filefoto<?php echo $i;?>"><br/>
											<?php endfor;?>
										</div>
									</div>
								</div>
								<!-- Submit -->
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<button type="submit" class="btn btn-primary">Simpan</button>
											<a href="<?= base_url('Destinasi'); ?>"><button type="button" class="btn btn-danger">Batal</button></a>
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
