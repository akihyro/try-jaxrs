package tryrest.hoges;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * ほげリソース。
 */
@Path("/hoges")
public class HogeResource {

    /**
     * データストア。
     */
    private static List<HogeData> store = new ArrayList<HogeData>();

    /**
     * URI情報。
     */
    @Context
    private UriInfo uriInfo;

    /**
     * データ作成。
     *
     * @param data データ。
     * @return レスポンス。
     */
    @POST
    public Response post(@BeanParam HogeData data) {
        store.add(data);
        URI uri = uriInfo.getAbsolutePathBuilder().path("{id}").build(store.size());
        return Response.created(uri).entity(data).build();
    }

    /**
     * データリスト取得。
     *
     * @return データリスト。
     */
    @GET
    public List<HogeData> get() {
        return store;
    }

    /**
     * データ取得。
     *
     * @param id データのID。
     * @return データ。
     */
    @GET
    @Path("/{id}")
    public HogeData get(@PathParam("id") int id) {
        return store.get(id - 1);
    }

}
