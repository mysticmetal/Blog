package com.blog.rest;

import com.blog.model.Categories;
import com.blog.model.Wp;
import com.blog.model.media.Media;
import com.blog.model.user.Users;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by tech6 on 4/18/16.
 */

public interface WpApi {

    /* Post all post - all */
    @GET("/wp-json/wp/v2/posts?per_page=10&_embed=true")
    public void getPosts( Callback<List<Wp>> response);

    /* Post by id */
    @GET("/wp-json/wp/v2/posts/{ID}")
    public void getPost(@Path("ID") String ID, Callback<Wp> response);

    /* Post by id paginate */
    @GET("/wp-json/wp/v2/posts?&_embed=true")
    public void getPostPaginate(@Query("per_page") int page, Callback<List<Wp>> response);

    /* Post by category - all */
    @GET("/wp-json/wp/v2/posts?per_page=100&_embed=true")
    public void getPostByCategory(@Query("filter[cat]") int filter, Callback<List<Wp>> response);

    @GET("/wp-json/wp/v2/media/{ID}")
    public void getThumbnail(@Path("ID") int ID, Callback<Media> response);

    @GET("/wp-json/wp/v2/users/{ID}")
    public void getPostAuthor(@Path("ID") int ID, Callback<Users> response);

    @GET("/wp-json/wp/v2/categories?per_page=100")
    public void getCategories( Callback<List<Categories>> response);



}
