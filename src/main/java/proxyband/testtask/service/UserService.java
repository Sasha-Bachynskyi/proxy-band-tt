package proxyband.testtask.service;

import proxyband.testtask.model.User;

import java.util.List;

public interface UserService {
    User add(User user);

    List<User> getAll();

    void delete(String id);

    User update(User user);
}
