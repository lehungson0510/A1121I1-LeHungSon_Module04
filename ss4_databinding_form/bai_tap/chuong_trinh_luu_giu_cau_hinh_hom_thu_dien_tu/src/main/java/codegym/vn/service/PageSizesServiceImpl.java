package codegym.vn.service;

import codegym.vn.repository.IPageSizeRepo;
import codegym.vn.repository.PageSizeRepoImpl;

import java.util.List;

public class PageSizesServiceImpl implements IPageSizeService {
    IPageSizeRepo pageSizeRepo = new PageSizeRepoImpl();
    @Override
    public List<Integer> pageSizeList() {
        return pageSizeRepo.pageSizeList();
    }
}
