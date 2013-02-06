struct message {
  char* message;
  int code;
};

struct request {
  char* first;
  char* second;
};

struct response {
  char* resp;
};

program SERVER {
	version SERVER_V1 {
		int sum(int) = 1;
		void print_message(struct message) = 2;
		struct response concat(struct request) = 3;
		void increment() = 4;
	} = 1;
} = 0x2fffffff;