package ir.maktabsharif.repository.request;

import ir.maktabsharif.model.Request;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class RequestRepositoryImpl extends BaseRepositoryImpl<Request, Long> implements RequestRepository {

    public RequestRepositoryImpl() {
        super(Request.class);
    }
}
