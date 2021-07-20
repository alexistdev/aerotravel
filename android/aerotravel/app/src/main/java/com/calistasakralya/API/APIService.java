package com.calistasakralya.API;

import android.content.Context;

import com.calistasakralya.BuildConfig;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.BookingModel;
import com.calistasakralya.model.ClientModel;
import com.calistasakralya.model.InboxModel;
import com.calistasakralya.model.InboxbalasModel;
import com.calistasakralya.model.LoginModel;
import com.calistasakralya.response.GetBalas;
import com.calistasakralya.response.GetBooking;
import com.calistasakralya.response.GetDestinasi;
import com.calistasakralya.response.GetFasilitas;
import com.calistasakralya.response.GetHarga;
import com.calistasakralya.response.GetInbox;
import com.calistasakralya.response.GetJadwal;
import com.calistasakralya.response.GetPaket;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    /* Kirim Balasan Pesan */
    @FormUrlEncoded
    @POST("api/Inbox/balas")
    Call<InboxbalasModel> simpanBalasan(@Field("key_token") String key_token,
                                        @Field("pesan") String pesan);

    /* Detail Pesan */
    @GET("api/Inbox/detail")
    Call<GetBalas> dataDetail(@Query("key_token") String key_token);

    /* Kirim Pesan */
    @FormUrlEncoded
    @POST("api/Inbox/tambah")
    Call<InboxModel> simpanPesan(@Field("id_user") String id_user,
                                 @Field("judul") String judul,
                                 @Field("pesan") String pesan);

    /* Simpan Booking */
    @FormUrlEncoded
    @POST("api/Booking/simpan")
    Call<BookingModel> simpanBooking(@Field("id_user") String id_user,
                                     @Field("id_paket") String id_paket,
                                     @Field("tanggal_wisata") String tanggal_wisata,
                                     @Field("jumlah_peserta") String jumlah_peserta);

    @GET("api/Paket/harga")
    Call<GetHarga> dapatkanHarga(@Query("id_paket") String id_paket);

    //API untuk menampilkan paket di spinner
    @GET("api/Paket/tampil")
    Call<GetPaket> spinnerPaket(@Query("kategori") String kategori);


    @FormUrlEncoded
    @PUT("api/User/akun/{id_user}")
    Call<ClientModel> updateAkun(@Path("id_user") String id_user,
                                 @Field("nama_lengkap") String nama_lengkap,
                                 @Field("no_telp") String no_telp,
                                 @Field("no_ktp") String no_ktp,
                                 @Field("alamat") String alamat,
                                 @Field("password") String password,
                                 @Field("token") String token);

    @GET("api/User/akun/{id_user}")
    Call<ClientModel> dataAkun(@Path("id_user") String id_user,
                               @Query("token") String token);

    @GET("api/Fasilitas/include/{id_destinasi}")
    Call<GetFasilitas> fasilitasInclude(@Path("id_destinasi") String id_destinasi,
                                        @Query("type") int type);


    @FormUrlEncoded
    @POST("api/Inbox/tampil")
    Call<GetInbox> daftarInbox(@Field("id_user") String id_user);

    @FormUrlEncoded
    @POST("api/Booking/tampil")
    Call<GetBooking> daftarBooking(@Field("id_user") String id_user);



    @GET("api/Home/jadwal/{id_destinasi}")
    Call<GetJadwal> jadwalWisata(@Path("id_destinasi") String id_destinasi,
                                 @Query("type") int type);

    //API untuk login
    @FormUrlEncoded
    @POST("api/Auth/login")
    Call<LoginModel> loginUser(@Field("email") String email,
                               @Field("password") String password);
    //API untuk registrasi
    @FormUrlEncoded
    @POST("api/Auth/daftar")
    Call<ClientModel> tambahUser(@Field("nama_lengkap") String nama_lengkap,
                                      @Field("email") String email,
                                      @Field("password") String password,
                                      @Field("no_telp") String no_telp);

    //API untuk menampilkan destinasi wisata di halaman home
    @GET("api/Home/destinasi")
    Call<GetDestinasi> listDestinasi();

    class Factory{
        public static APIService create(Context mContext){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.connectTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            builder.addInterceptor(new NetworkConnectionInterceptor(mContext));
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            if(BuildConfig.DEBUG){
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            }else {
                logging.setLevel(HttpLoggingInterceptor.Level.NONE);
            }

            OkHttpClient client = builder.addInterceptor(logging).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(APIService.class);
        }
    }
}
