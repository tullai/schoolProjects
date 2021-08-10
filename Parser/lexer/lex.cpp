#include "lex.h"

map<string, string> keywords = {
    {"for", "loop_stmt"},
    {"if", "if_stmt"},
    {"else", "else_stat"},
    {"boolean", "bool_type"},
    {"int", "data_type"},
    {"void", "data_type"},
    {"string", "String_type"},
    {"true", "TRUE"},
    {"false", "FALSE"},
    {"main", "MAIN_FUNC"},
    {"return", "RETURN_STMT"}};
map<string, string> delimiters = {
    {";", "SEMICOLON"},
    {"(", "LEFT_PAREN"},
    {")", "RIGHT_PAREN"},
    {"{", "LEFT_BRACE"},
    {"}", "RIGHT_BRACE"},
    {"[", "LEFT_BRACKET"},
    {"]", "RIGHT_BRACKET"}};
map<string, string> operators = {
    {"+", "PLUS_OP"},
    {"*", "MUL_OP"},
    {">", "GT"},
    {"<", "LT"},
    {"=", "EQUAL"},
    {"<=", "LESS_OR_EQUAL"},
    {">=", "GREATER_OR_EQUAL"},
    {"==", "COMPARE_OP"}};
vector<pair<string, string>> tokens;
int flag = 0; // flag=1 means integer literal flag=2 means string literal flag=3 means identifier
string tok;

int handleSL(string line, int c)
{
    c++;
    int n = line.length();
    while (c != n)
    {
        if (line[c] == '"')
        {
            c++;
            tokens.push_back({tok, "STRING_LITERAL"});
            tok = "";
            return c;
        }
        else if (line[c] == '/' && line[c + 1] == '/')
            break;
        else
            tok += line[c++];
    }
    tokens.push_back({tok, "ILLEGAL_STRING_LITERAL"});
    tok = "";
    return c;
}

vector<pair<string, string>> makeTokens(string line, int linenumber)
{
    tokens.clear();
    int n = line.length(), x = 0;
    string token, illTok;
    pair<string, string> val;
    if (line == "")
    {
    }
    else
    {
        int c = 0;
        while (c != n)
        {
            if (line[c] == '"')
            {
                c = handleSL(line, c);
            }
            else if (flag == 0 && (line[c] >= 'a' && line[c] <= 'z') || (line[c] >= 'A' && line[c] <= 'Z'))
            { //This is for Identifier
                flag = 3;
                token = line[c++];
            }
            else if (flag == 0 && (line[c] >= 48 && line[c] <= 57))
            { //This is for integer Literal
                flag = 1;
            }
            else if (flag == 1)
            { // This is for integer literal
                if ((line[c] >= 48 && line[c] <= 57))
                {
                    token += line[c++];
                }
                if (line[c] < 48 || line[c] > 57)
                {
                    flag = 0;
                    val.first = token;
                    val.second = "INTEGER LITERAL";
                    tokens.push_back(val);
                    token = "";
                }
            }
            else if (flag == 3)
            { //Handles Identifiers
                if ((line[c] >= 'a' && line[c] <= 'z') || (line[c] >= 'A' && line[c] <= 'Z') || line[c] == '_' || (line[c] >= 48 && line[c] <= 57))
                {
                    token += line[c++];
                }
                else
                {
                    flag = 0;
                    helper(token, val);
                    token = "";
                }
            }
            else if (line[c] == '/' && line[c + 1] == '/') //Comments are handled in this
            {
                if (illTok != "")
                {
                    val.first = illTok;
                    val.second = "ILLEGAL TOKEN";
                    tokens.push_back(val);
                    illTok = "";
                }
                else
                    helper(token, val);
                break;
            }
            else if (line[c] == ' ') // Handles spaces and tabs
            {
                helper(token, val);
                token = "";
                c++;
            }
            else if (line[c] == '(' || line[c] == ')' || line[c] == '{' || line[c] == '}' || line[c] == '[' || line[c] == ']' || line[c] == ';')
            { //Handles Delimiters like (,),{,},[,],;
                helper(token, val);
                token = line[c];
                val.first = token;
                val.second = delimiters[token];
                tokens.push_back(val);
                c++;
                token = "";
            }
            else if ((line[c] == '+' || line[c] == '*') || ((line[c] == '=' || line[c] == '>' || line[c] == '<') && line[c + 1] != '='))
            { //Handles Operators like + , *, =, >, <
                helper(token, val);
                token = line[c];
                val.first = token;
                val.second = operators[token];
                tokens.push_back(val);
                c++;
                token = "";
            }
            else if ((line[c] == '=' || line[c] == '>' || line[c] == '<') && line[c + 1] == '=')
            { //Handles Operators like >=, <=, ==
                helper(token, val);
                token = line[c++];
                token += line[c];
                val.first = token;
                val.second = operators[token];
                tokens.push_back(val);
                c++;
                token = "";
            }
            else if (c == n - 1)
            {
                if (line[c] != ' ' || token != "")
                {
                    helper(token, val);
                }
                c++;
            }
            else
            {
                illTok += line[c++];
                x = c;
            }
            if (x != c && illTok != "")
            { //Handles Illegal tokens
                val.first = illTok;
                val.second = "ILLEGAL TOKEN";
                tokens.push_back(val);
                illTok = "";
            }
        }
    }
    return tokens;
}

void helper(string token, pair<string, string> val)
{
    if (token != "")
    {
        if (keywords.find(token) != keywords.end())
        {
            val.first = token;
            val.second = keywords[token];
        }
        else
        {
            val.first = token;
            val.second = "IDENTIFIER";
        }
        tokens.push_back(val);
    }
}
