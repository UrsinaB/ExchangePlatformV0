package ch.fhnw.crm.crmwebservice.business;

@Service
@Validated
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Validator validator;
    
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUser(@Valid User user) throws Exception {
        if (user.getId() == null) {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new Exception("Email address " + user.getEmail() + " already assigned another user.");
            }
        } else if (userRepository.findByEmailAndIdAndNameNot(user.getEmail(), user.getId(),user.getName()) != null) {
            throw new Exception("Email address " + user.getEmail() + " and name " + user.getName() + " already assigned another user.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    
    public void deleteUser(Long userId)
	{
		userRepository.deleteById(userId);
	}
	
	public User findUserById(Long userId, String email) throws Exception {
		List<User> userList = userRepository.findByEmail(userId, email);
		if(userList.isEmpty()){
			throw new Exception("No user with ID "+userId+" found.");
		}
		return userList.get(0);
	}

	public List<User> findAllUsers(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    

}