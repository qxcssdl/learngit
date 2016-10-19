#include <iostream>
#include <cstdio>
using namespace std;

int main()
{
 int cases;
 float m, n;
 cin >> cases;
 for ( int i = 0; i < cases; ++i )
 {
  cin >> m >> n;
  cout << "Scenario #" << i+1 << ":" << endl;
  if ( (int)m % 2 == 0 || (int)n % 2 == 0 )
   printf( "%.2f\n\n", m*n );
  else
   printf( "%.2f\n\n", m*n+0.41 );
 }

return 0;
}
