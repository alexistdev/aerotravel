<?php
defined('BASEPATH') or exit('No direct script access allowed');
?>
<!DOCTYPE html>
<html>
<?php $this->load->view('template/v_header2') ?>

<body class="hold-transition sidebar-mini pace-danger">
<div class="wrapper">
	<!-- Site wrapper -->
	<?php $this->load->view('template/v_navbar') ?>
	<?php $this->load->view('template/v_sidebar') ?>
	<?php $this->load->view('konten/k_jadwal') ?>
	<?php $this->load->view('template/v_footer') ?>
</div>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- Bootstrap 4 -->
<script src="<?= base_url('vendor/almasaeed2010/adminlte') ?>/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<?= base_url('vendor/almasaeed2010/adminlte') ?>/dist/js/adminlte.min.js"></script>
<!-- pace-progress -->
<script src="<?= base_url('vendor/almasaeed2010/adminlte') ?>/plugins/pace-progress/pace.min.js"></script>
<!-- DataTables -->
<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.7/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.7/js/responsive.bootstrap4.min.js"></script>
<script>
	$(document).ready(function () {
		$('#tableOpen').DataTable({
			responsive: true,
			"autoWidth": false,
		});

		var companies2 = $('#tablePrivate').DataTable({
			responsive: true,
			"autoWidth": false,
		});

		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
			$($.fn.dataTable.tables(true)).DataTable()
				.columns.adjust()
				.responsive.recalc();
		});
	});




	$(window).bind("load", function() {
		window.setTimeout(function() {
			$(".alert").fadeTo(500, 0).slideUp(500, function() {
				$(this).remove();
			});
		}, 2000);
	});
	$(function () {
		$('[data-toggle="tooltip"]').tooltip()
	});

	/** Saat tombol modal diklik */
	$(document).on("click", "#tombolTambah", function () {
		var idDestinasi = $(this).data('id');
		$("#idDestinasi").val(idDestinasi);
	});
</script>
</body>

</html>
