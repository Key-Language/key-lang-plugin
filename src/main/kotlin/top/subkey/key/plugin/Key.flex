package top.subkey.key.plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import top.subkey.key.plugin.psi.KeyTypes;
import com.intellij.psi.TokenType;

import static top.subkey.key.plugin.psi.KeyTypes.*;

%%

%class KeyLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
END_OF_LINE_COMMENT=("//")[^\r\n]*

///////////////////////////////////////////////////////////////////////////////////////////////////
// Identifier
///////////////////////////////////////////////////////////////////////////////////////////////////
IDENTIFIER = [_\p{xidstart}][\p{xidcontinue}]*
SUFFIX     = {IDENTIFIER}

///////////////////////////////////////////////////////////////////////////////////////////////////
// Literals
///////////////////////////////////////////////////////////////////////////////////////////////////
EXPONENT      = [eE] [-+]? [0-9_]+
INT_LITERAL = ( {DEC_LITERAL}
              | {HEX_LITERAL}
              | {OCT_LITERAL}
              | {BIN_LITERAL} ) {EXPONENT}? {SUFFIX}?

DEC_LITERAL = [0-9] [0-9_]*
HEX_LITERAL = "0x" [a-fA-F0-9_]*
OCT_LITERAL = "0o" [0-7_]*
BIN_LITERAL = "0b" [01_]*


CHAR_LITERAL   = ( \' ( [^\\\'\r\n] | \\[^\r\n] | "\\x" [a-fA-F0-9]+ | "\\u{" [a-fA-F0-9][a-fA-F0-9_]* "}"? )? ( \' {SUFFIX}? | \\ )? )
               | ( \' [\p{xidcontinue}]* \' {SUFFIX}? )
STRING_LITERAL = \" ( [^\\\"] | \\[^] )* ( \" {SUFFIX}? | \\ )?
%%

<YYINITIAL> {
    {END_OF_LINE_COMMENT}                           { return COMMENT; }
    {CRLF}({CRLF}|{WHITE_SPACE})+                   { return TokenType.WHITE_SPACE; }
    {WHITE_SPACE}+                                  { return TokenType.WHITE_SPACE; }
    ({CRLF}|{WHITE_SPACE})+                         { return TokenType.WHITE_SPACE; }
    "="                                             { return EQ; }
    "<"                                             { return LT; }
    "["                                             { return LBRACK; }
    "]"                                             { return RBRACK; }
    "("                                             { return LPAREN; }
    ")"                                             { return RPAREN; }
    "{"                                             { return LBRACE; }
    "}"                                             { return RBRACE; }
    ","                                             { return COMMA; }
    ";"                                             { return SEMICOLON; }
    "let"                                           { return LET; }
    {IDENTIFIER}                                    { return ID; }
    {INT_LITERAL}                                   { return INTEGER_LITERAL; }
    {STRING_LITERAL}                                { return STRING_LITERAL; }
}

    [^]                                             { return TokenType.BAD_CHARACTER; }