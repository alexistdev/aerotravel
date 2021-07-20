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
					<h1>Destinasi Wisata</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<?= base_url('Member') ?>">Home</a></li>
						<li class="breadcrumb-item active">Destinasi Wisata</li>
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
							<h3 class="card-title">Daftar Destinasi Paket Wisata</h3>
							<a href="<?= base_url('Destinasi/tambah'); ?>"><button class="btn btn-success btn-sm float-right">Tambah Data</button></a>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table id="tableDestinasi" class="table table-bordered table-hover" style="width: 100%">
								<thead>
								<tr>
									<th class="text-center">No</th>
									<th class="text-center" width="10%">Judul </th>
									<th class="text-center">Deskripsi</th>
									<th class="text-center">Gambar1</th>
									<th class="text-center">Gambar2</th>
									<th class="text-center">Gambar3</th>
									<th class="text-center">Gambar4</th>
									<th class="text-center">Gambar5</th>
									<th class="text-center" width="10%">Action</th>
								</tr>
								</thead>
								<tbody>
									<?php $no=1;foreach($dataDestinasi->result_array() as $rowDestinasi): ?>
										<tr>
											<td class="text-center"><?= $no++; ?></td>
											<td class="text-center"><?= sanitasi($rowDestinasi['judul_destinasi']); ?></td>
											<td class="text-center"><?= sanitasi($rowDestinasi['deskripsi']); ?></td>
											<td class="text-center"><img src="<?= base_url('gambar/'.sanitasi($rowDestinasi['gambar1'])); ?>" alt="<?= sanitasi($rowDestinasi['gambar1']); ?>" width="100px"></td>
											<td class="text-center"><img src="<?= base_url('gambar/'.sanitasi($rowDestinasi['gambar2'])); ?>" alt="<?= sanitasi($rowDestinasi['gambar2']); ?>" width="100px"></td>
											<td class="text-center"><img src="<?= base_url('gambar/'.sanitasi($rowDestinasi['gambar3'])); ?>" alt="<?= sanitasi($rowDestinasi['gambar3']); ?>" width="100px"></td>
											<td class="text-center"><img src="<?= base_url('gambar/'.sanitasi($rowDestinasi['gambar4'])); ?>" alt="<?= sanitasi($rowDestinasi['gambar4']); ?>" width="100px"></td>
											<td class="text-center"><img src="<?= base_url('gambar/'.sanitasi($rowDestinasi['gambar5'])); ?>" alt="<?= sanitasi($rowDestinasi['gambar5']); ?>" width="100px"></td>
											<td class="text-center" width="20%">
												<a href="<?= base_url('Destinasi/edit/'.encrypt_url(sanitasi($rowDestinasi['id_destinasi']))); ?>"><button class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Edit"><i class="fas fa-edit"></i></button></a>
												<a href="<?= base_url('Destinasi/fasilitas/'.encrypt_url(sanitasi($rowDestinasi['id_destinasi']))); ?>"><button class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="top" title="Fasilitas"><i class="fas fa-icons"></i></button></a>
												<a href="<?= base_url('Destinasi/jadwal/'.encrypt_url(sanitasi($rowDestinasi['id_destinasi']))); ?>"><button class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="top" title="Jadwal"><i class="fas fa-calendar-alt"></i></button></a>
												<span data-toggle="modal" id="tombolHapus" data-target="#modalKunci" data-id="<?= encrypt_url(sanitasi($rowDestinasi['id_destinasi'])); ?>">
													<button class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="top" title="Hapus"><i class="fas fa-trash"></i></button>
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
<div class="modal fade" id="modalKunci" tabindex="-1" aria-labelledby="modalHapusLabel" aria-hidden="true">
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
