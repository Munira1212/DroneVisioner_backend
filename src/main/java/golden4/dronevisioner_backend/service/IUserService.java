package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Long>{
    List<User> findByName(String name);
}
