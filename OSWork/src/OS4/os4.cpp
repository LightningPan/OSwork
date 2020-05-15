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
		if (status == 0 || status == -1)break;
		count++;
		
	}
	if (status == -1) {
		cout << "创建失败" << endl;
	}
	else if (status == 0) {

		cout << "子进程 pid:" <<getpid()<<"  "<<char(display+(getpid()-temp))<< endl;
	}
	else {
		cout << "父进程 pid:"  <<getpid()<<"  "<<char(display + (getpid() - temp)) <<endl;
	}
	
	
}
