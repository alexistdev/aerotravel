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
					<h1>Data Client</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<?= base_url('Member') ?>">Home</a></li>
						<li class="breadcrumb-item active">Client</li>
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
			<div class="row">
				<!-- Khusus Personal Hosting -->
				<div class="col-md-12">
					<div class="card card-dark">
						<div class="card-header">
							<h3 class="card-title">Daftar Client</h3>
							<a href="<?= base_url('Client/tambah'); ?>"><button class="btn btn-success btn-sm float-right">Tambah Data</button></a>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table id="tabelUser" class="table table-bordered table-hover">
								<thead>
								<tr>
									<th class="text-center">No</th>
									<th class="text-center">Nama </th>
									<th class="text-center">Email</th>
									<th class="text-center">Nomor Telepon</th>
									<th class="text-center">No.Ktp</th>
									<th class="text-center">Alamat</th>
									<th class="text-center">Action</th>
								</tr>
								</thead>
								<tbody>
								<?php
								$no = 1;
								foreach ($dataUser as $rowClient) :?>
									<tr>
										<td class="text-center"><?= sanitasi($no++); ?></td>
										<td class="text-center"><?= ucwords(sanitasi($rowClient['nama_lengkap'])); ?></td>
										<td class="text-center"><?= sanitasi($rowClient['email']); ?></td>
										<td class="text-center"><?= sanitasi($rowClient['no_telp']); ?></td>
										<td class="text-center"><?= sanitasi($rowClient['no_ktp']); ?></td>
										<td class="text-center"><?= sanitasi($rowClient['alamat']); ?></td>
										<td class="text-center">
											<a href="<?= base_url('Client/edit/'.encrypt_url(sanitasi($rowClient['id_user']))); ?>"><button class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Edit"><i class="fas fa-edit"></i></button></a>
											<span data-toggle="modal" id="tombolHapus" data-target="#modalHapus" data-id="<?= sanitasi($rowClient['id_user']); ?>">
												<button class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Hapus"><i class="fas fa-trash"></i></button>
											</span>
										</td>
									</tr>
								<?php endforeach; ?>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<!--	Modal Kunci Pesan	-->
<div class="modal fade" id="modalHapus" tabindex="-1" aria-labelledby="modalHapusLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Hapus Data</h5>
			</div>
			<div class="modal-body">
				Apakah anda yakin ingin menghapus data ini ?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Batal</button>
				<a href="" id="urlKunci"><button  type="button" class="btn btn-danger">Hapus</button></a>
			</div>
		</div>
	</div>
</div>
<!--	/Modal Kunci Pesan	-->
