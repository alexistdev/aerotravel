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
					<h1>Daftar Booking</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<?= base_url('Member') ?>">Home</a></li>
						<li class="breadcrumb-item active">Daftar Booking</li>
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
							<h3 class="card-title">Daftar Booking</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table id="tableDestinasi" class="table table-bordered table-hover" style="width: 100%">
								<thead>
								<tr>
									<th class="text-center">No</th>
									<th class="text-center" >Kode Booking </th>
									<th class="text-center">Tanggal Wisata</th>
									<th class="text-center">Tanggal Dibuat</th>
									<th class="text-center">Jumlah Peserta</th>
									<th class="text-center">Total Harga</th>
									<th class="text-center">Status</th>
									<th class="text-center" width="10%">Action</th>
								</tr>
								</thead>
								<tbody>
									<?php $no=1; foreach($dataTransaksi->result_array() as $rowBooking): ?>
										<tr>
											<td class="text-center"><?= $no++; ?></td>
											<td class="text-center"><?= sanitasi($rowBooking['kode_booking']); ?></td>
											<td class="text-center"><?= date("d-m-Y", strtotime(sanitasi($rowBooking['tanggal_wisata']))); ?></td>
											<td class="text-center"><?= date("d-m-Y", strtotime(sanitasi($rowBooking['tanggal_dibuat']))); ?></td>
											<td class="text-center"><?= sanitasi($rowBooking['jumlah_peserta']); ?></td>
											<td class="text-center"><?= sanitasi($rowBooking['total_harga']); ?></td>
											<td class="text-center">
												<?php if(sanitasi($rowBooking['status']) == 2){ ?>
												<small class="badge badge-danger">PENDING</small>
												<?php } else { ?>
													<small class="badge badge-success">VERIFIKASI</small>
												<?php } ?>
												</td>
											<td class="text-center">
												<?php if(sanitasi($rowBooking['status']) == 2) {?>
													<a href="<?= base_url('Transaksi/validasi/'.encrypt_url(sanitasi($rowBooking['id_booking']))); ?>"><button class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Validasi"><i class="fas fa-check-square"></i></button></a>
												<?php } ?>
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
