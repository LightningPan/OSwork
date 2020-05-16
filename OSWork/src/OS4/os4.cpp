#include<iostream>
#include <unistd.h>

using namespace std;
int main(){
	int status;
	char display='A';
	int count = 0;
	int temp = getpid();
	while (count < 2) {
		status = fork();
		if (status == 0 )break;
		count++;
		
	}
	if (status == -1) {
		cout << "创建失败" << endl;
	}
	else if (status == 0) {
		for (int i = 0;i<10;i++) {
			cout << "子进程 pid:" << getpid() << "  " << char(display + (getpid() - temp)) << endl;
		}
		return 0;
	}
	else {
		for (int i = 0; i < 10; i++) {
			cout << "父进程 pid:" << getpid() << "  " << char(display + (getpid() - temp)) << endl;
		}
		return 0;
	}
	
	
}
