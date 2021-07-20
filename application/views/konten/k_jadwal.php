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
					<h1>Jadwal Kegiatan Wisata</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<?= base_url('Member') ?>">Home</a></li>
						<li class="breadcrumb-item"><a href="<?= base_url('Destinasi'); ?>">Destinasi Wisata</a></li>
						<li class="breadcrumb-item active">Jadwal Kegiatan</li>
					</ol>
				</div>
			</div>
		</div><!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<!-- Small boxes (Stat box) -->
			<div class="row">
				<div class="col-md-12">
					<!-- Start Pesan -->
					<?php
					echo $this->session->flashdata('pesan');
					echo $this->session->flashdata('pesan2');
					echo $this->session->flashdata('pesan3');?>
					<!-- End Pesan -->
				</div>
			</div>
			<!--	Start Row		-->
			<div class="row">

				<div class="col-12 col-sm-12">

					<div class="card card-dark card-tabs">
						<div class="card-header p-0 pt-1">
							<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
								<li class="nav-item">
									<a class="nav-link active" id="custom-tabs-one-home-tab" data-toggle="pill" href="#custom-tabs-one-home" role="tab" aria-controls="custom-tabs-one-home" aria-selected="true">Open Trip</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" id="custom-tabs-one-profile-tab" data-toggle="pill" href="#tab2" role="tab" aria-controls="custom-tabs-one-profile" aria-selected="false">Private Trip</a>
								</li>

							</ul>


						</div>
						<div class="card-body">
						<span data-toggle="modal" id="tombolTambah" data-target="#modalTambah" data-id="<?= sanitasi($idDestinasi); ?>">
								<button class="btn btn-primary float-right"> Tambah</button>
						</span>
							<div class="tab-content mt-2" id="custom-tabs-one-tabContent">
								<div class="tab-pane fade show active" id="custom-tabs-one-home" role="tabpanel" aria-labelledby="custom-tabs-one-home-tab">

									<table id="tableOpen" class="table table-bordered table-hover" style="width: 100%">
										<thead>
										<tr>
											<th class="text-center" width="5%">No</th>
											<th class="text-center" width="10%">Destinasi Wisata </th>
											<th class="text-center" width="10%">Type </th>
											<th class="text-center" width="10%">Waktu</th>
											<th class="text-center" width="30%">Aktivitas</th>
											<th class="text-center" width="10%">Action</th>
										</tr>
										</thead>
										<tbody>
										<?php $no = 1;
										foreach($openTrip->result_array() as $rowJadwal) :?>
											<tr>
												<td class="text-center"><?= $no++; ?></td>
												<td class="text-center"><?= sanitasi($rowJadwal['judul_destinasi']); ?></td>
												<td class="text-center"><?= (sanitasi($rowJadwal['type']) == 1)? "Open Trip" : "Private Trip"; ?></td>
												<td class="text-center"><?= sanitasi($rowJadwal['waktu']); ?></td>
												<td><?= sanitasi($rowJadwal['keterangan']); ?></td>
												<td class="text-center">
													<a href="<?= base_url('Destinasi/hapus_jadwal/'.encrypt_url(sanitasi($rowJadwal['id_destinasi'])).'/'.encrypt_url(sanitasi($rowJadwal['id_jadwal']))); ?>"><button class="btn btn-danger"><i class="fas fa-trash"></i></button></a>
												</td>
											</tr>

										<?php endforeach; ?>
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="custom-tabs-one-profile-tab">
									<table id="tablePrivate" class="table table-bordered table-hover" style="width: 100%">
										<thead>
										<tr>
											<th class="text-center" width="5%">No</th>
											<th class="text-center" width="10%">Destinasi Wisata </th>
											<th class="text-center" width="10%">Type </th>
											<th class="text-center" width="10%">Waktu</th>
											<th class="text-center" width="30%">Aktivitas</th>
											<th class="text-center" width="10%">Action</th>
										</tr>
										</thead>
										<tbody>
										<?php $no = 1;
										foreach($privateTrip->result_array() as $rowJadwal) :?>
											<tr>
												<td class="text-center"><?= $no++; ?></td>
												<td class="text-center"><?= sanitasi($rowJadwal['judul_destinasi']); ?></td>
												<td class="text-center"><?= (sanitasi($rowJadwal['type']) == 1)? "Open Trip" : "Private Trip"; ?></td>
												<td class="text-center"><?= sanitasi($rowJadwal['waktu']); ?></td>
												<td><?= sanitasi($rowJadwal['keterangan']); ?></td>
												<td class="text-center">
													<a href="<?= base_url('Destinasi/hapus_jadwal/'.encrypt_url(sanitasi($rowJadwal['id_destinasi'])).'/'.encrypt_url(sanitasi($rowJadwal['id_jadwal']))); ?>"><button class="btn btn-danger"><i class="fas fa-trash"></i></button></a>
												</td>
											</tr>

										<?php endforeach; ?>
										</tbody>
									</table>
								</div>

							</div>

							<a href="<?= base_url('Destinasi'); ?>"><button class="btn btn-danger mt-5">Kembali</button></a>
						</div>
						<!-- /.card -->
					</div>
				</div>
			</div>
			<!--	/End Row		-->
		</div>
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<!--	Modal Kunci Pesan	-->
<div class="modal fade" id="modalTambah" tabindex="-1" aria-labelledby="modalHapusLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Tambah Data</h5>
			</div>
			<div class="modal-body">
				<form action="<?= base_url('Destinasi/jadwal_tambah'); ?>" method="post">
					<!-- Pilih Type Trip	-->
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="typeTrip">Open/Private Trip <span class="text-danger">*</span></label>
								<select name="typeTrip" id="typeTrip" class="form-control">
									<option value="1">Open Trip</option>
									<option value="2">Private</option>
								</select>
							</div>
						</div>
					</div>
					<!-- Waktu	-->
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="waktuPelaksanaan">Waktu Pelaksanaan <span class="text-danger">*</span></label>
								<input type="text" name="waktuPelaksanaan" id="waktuPelaksanaan" maxlength="50" class="form-control" value="<?= set_value('waktuPelaksanaan'); ?>" placeholder="08:00 - 09:00" required="required">
							</div>
						</div>
					</div>
					<!-- Kegiatan	-->
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="namaKegiatan">Kegiatan <span class="text-danger">*</span></label>
								<input type="text" name="namaKegiatan" id="namaKegiatan" maxlength="255" class="form-control" value="<?= set_value('namaKegiatan'); ?>" placeholder="Nama Kegiatan" required="required">
							</div>
						</div>
					</div>
					<!-- Destinasi	-->
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<input type="hidden" name="idDestinasi" id="idDestinasi" maxlength="120" class="form-control" value="<?= set_value('idDestinasi'); ?>" required="required">
							</div>
						</div>
					</div>
					<!-- Submit -->
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Simpan</button>
								<button type="button" class="btn btn-danger" data-dismiss="modal">Batal</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!--	/Modal Kunci Pesan	-->
