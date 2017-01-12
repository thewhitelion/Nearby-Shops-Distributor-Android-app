package org.localareadelivery.distributorapp.RetrofitRESTContract;

import org.localareadelivery.distributorapp.Model.Order;
import org.localareadelivery.distributorapp.ModelEndpoints.OrderEndPoint;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sumeet on 12/3/16.
 */
public interface OrderServiceShopStaff {


    @PUT("/api/Order/ShopStaff/SetConfirmed/{OrderID}")
    Call<ResponseBody> confirmOrder(@Header("Authorization") String headers,
                                    @Path("OrderID")int orderID);


    @PUT("/api/Order/ShopStaff/SetOrderPacked/{OrderID}")
    Call<ResponseBody> setOrderPacked(@Header("Authorization") String headers,
                                      @Path("OrderID")int orderID);



//    @PUT("/api/Order/ShopStaffAccounts/HandoverToDelivery/{OrderID}")
//    Call<ResponseBody> handoverToDelivery(@Path("OrderID")int orderID,@Body Order order);


    @PUT("/api/Order/ShopStaff/HandoverToDelivery/{DeliveryGuySelfID}")
    Call<ResponseBody> handoverToDelivery(@Header("Authorization") String headers,
                                          @Path("DeliveryGuySelfID")int deliveryGuyID,
                                          @Body List<Order> ordersList);



    @PUT("/api/Order/ShopStaff/UndoHandover/{OrderID}")
    Call<ResponseBody> undoHandover(@Header("Authorization") String headers,
                                    @Path("OrderID")int orderID);



    @PUT("/api/Order/ShopStaff/MarkDelivered/{OrderID}")
    Call<ResponseBody> markDelivered(@Header("Authorization") String headers,
                                     @Path("OrderID")int orderID);


    @PUT("/api/Order/ShopStaff/PaymentReceived/{OrderID}")
    Call<ResponseBody> paymentReceived(@Header("Authorization") String headers,
                                       @Path("OrderID")int orderID);


    @PUT("/api/Order/ShopStaff/PaymentReceived")
    Call<ResponseBody> paymentReceivedBulk(@Header("Authorization") String headers,
                                           @Body List<Order> ordersList);


    @PUT("/api/Order/ShopStaff/CancelByShop/{OrderID}")
    Call<ResponseBody> cancelledByShop(@Header("Authorization") String headers,
                                       @Path("OrderID")int orderID);




    @PUT("/api/Order/ShopStaff/AcceptReturnCancelledByShop/{OrderID}")
    Call<ResponseBody> acceptReturnCancelledByShop(@Header("Authorization") String headers,
                                                   @Path("OrderID")int orderID);



    @PUT("/api/Order/ShopStaff/AcceptReturnCancelledByUser/{OrderID}")
    Call<ResponseBody> acceptReturnCancelledByUser(@Header("Authorization") String headers,
                                                   @Path("OrderID")int orderID);



    @PUT("/api/Order/ShopStaff/AcceptReturn/{OrderID}")
    Call<ResponseBody> acceptReturn(@Header("Authorization") String headers,
                                    @Path("OrderID")int orderID);


    @GET("/api/Order/ShopStaff")
    Call<OrderEndPoint> getOrders(@Header("Authorization") String headers,
                                @Query("OrderID")Integer orderID,
                              @Query("EndUserID")Integer endUserID,
                              @Query("PickFromShop") Boolean pickFromShop,
                              @Query("StatusHomeDelivery")Integer homeDeliveryStatus,
                              @Query("StatusPickFromShopStatus")Integer pickFromShopStatus,
                              @Query("DeliveryGuyID")Integer deliveryGuyID,
                              @Query("PaymentsReceived") Boolean paymentsReceived,
                              @Query("DeliveryReceived") Boolean deliveryReceived,
                              @Query("latCenter")Double latCenter, @Query("lonCenter")Double lonCenter,
                              @Query("PendingOrders") Boolean pendingOrders,
                              @Query("SortBy") String sortBy,
                              @Query("Limit")Integer limit, @Query("Offset")Integer offset,
                              @Query("metadata_only")Boolean metaonly);




    @GET("/api/Order/ShopStaff")
    Call<OrderEndPoint> getOrders(@Header("Authorization") String headers,
                                  @Query("OrderID")Integer orderID,
                                  @Query("EndUserID")Integer endUserID,
                                  @Query("PickFromShop") Boolean pickFromShop,
                                  @Query("StatusHomeDelivery")Integer homeDeliveryStatus,
                                  @Query("StatusPickFromShopStatus")Integer pickFromShopStatus,
                                  @Query("DeliveryGuyID")Integer deliveryGuyID,
                                  @Query("PaymentsReceived") Boolean paymentsReceived,
                                  @Query("DeliveryReceived") Boolean deliveryReceived,
                                  @Query("latCenter")Double latCenter, @Query("lonCenter")Double lonCenter,
                                  @Query("PendingOrders") Boolean pendingOrders,
                                  @Query("SearchString") String searchString,
                                  @Query("SortBy") String sortBy,
                                  @Query("Limit")Integer limit, @Query("Offset")Integer offset,
                                  @Query("metadata_only")Boolean metaonly);





    // previous methods

//    @GET("/api/Order/{id}")
//    Call<Order> getOrder(@Path("id") int orderID);

//    @PUT("/api/Order/{OrderID}")
//    Call<ResponseBody> putOrder(@Path("OrderID") int orderID, @Body Order order);

//    @PUT("/api/Order/ReturnOrder/{OrderID}")
//    Call<ResponseBody> returnOrder(@Path("OrderID") int orderID);

//    @PUT("/api/Order/CancelByShop/{OrderID}")
//    Call<ResponseBody> cancelOrderByShop(@Path("OrderID") int orderID);

}
