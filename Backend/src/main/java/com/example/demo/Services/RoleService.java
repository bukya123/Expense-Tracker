package com.example.demo.Services;

import com.example.demo.Enums.ERole;
import com.example.demo.Modules.Role;

public interface RoleService {
    Role findByName(ERole eRole);
}
