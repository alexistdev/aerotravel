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
			<div class="row">
				<div class="col-md-12">
					<?php
					echo $this->session->flashdata('pesan');
					echo $this->session->flashdata('pesan2'); ?>
				</div>
			</div>
		<!-- ROW	-->
			<div class="row">
				<div class="col-md-12">
					<div class="card direct-chat direct-chat-primary">
						<div class="card-header">
							<h3 class="card-title">Direct Chat</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">

							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<div class="direct-chat-messages">
											<div class="direct-chat-msg">
												<?php foreach($dataDetailInbox as $rowDetail) :
													$isAdmin = sanitasi($rowDetail['is_admin']);
													?>
													<!--	START PESAN KANAN -->
													<div class="direct-chat-msg <?= ($isAdmin==2)? "right":""; ?>">
														<div class="direct-chat-infos clearfix">
															<span class="direct-chat-name float-<?= ($isAdmin==2)? "right":"left"; ?>"><?= ($isAdmin==2)? "Anda":"USER"; ?></span>
															<span class="direct-chat-timestamp float-<?= ($isAdmin==2)? "left":"right"; ?>"><?= date("d-m-Y", strtotime(sanitasi($rowDetail['time']))); ?></span>
														</div>
														<!-- /.direct-chat-infos -->
														<img class="direct-chat-img" src="<?= base_url('gambar/default.jpg'); ?>" alt="message user image">
														<!-- /.direct-chat-img -->
														<div class="direct-chat-text">
															<?= sanitasi($rowDetail['pesan']); ?>
														</div>
														<!-- /.direct-chat-text -->
													</div>
													<!--	/END PESAN KANAN -->
												<?php  endforeach; ?>

											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<form action="<?= base_url('Inbox/detail/'.$token); ?>" method="post">
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<textarea name="pesan" class="form-control" id="pesan" cols="30" rows="10" required="required"></textarea>
													</div>
												</div>
											</div>
											<!-- Submit -->
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<button type="submit" class="btn btn-primary">Simpan</button>
														<a href="<?= base_url('Inbox'); ?>"><button type="button" class="btn btn-danger">Batal</button></a>
													</div>
												</div>
											</div>
										</form>
									</div>

								</div>
							</div>


						</div>
						<!--	/END CARD BODY	-->
					</div>

				</div>
			</div>
		<!--	/END ROW -->
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
