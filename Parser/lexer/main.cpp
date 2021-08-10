#include "lex.h"

int main(int argc, char **argv)
{
    if (argc != 2)
    {
        printf("Fatal Error:no input files\n");
    }
    vector<pair<string, string>> Tokens;
    string filename = argv[1];
    string line;
    int count = 0;
    ifstream readFile(filename);
    if (!readFile)
    {
        cout << "That File Doesn't Exists" << endl;
        return 1;
    }
    while (getline(readFile, line))
    {
        Tokens.clear();
        count++;
        Tokens = makeTokens(line, count);
        for (int i = 0; i < Tokens.size(); i++)
            cout << Tokens[i].first << ", " << Tokens[i].second << ", line number " << count << endl;
    }
    readFile.close();
    return 0;
}
