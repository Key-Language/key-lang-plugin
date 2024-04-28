// This is a generated file. Not intended for manual editing.
package top.subkey.key.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import top.subkey.key.plugin.psi.impl.*;

public interface KeyTypes {

  IElementType ASSIGN_DEF = new KeyElementType("ASSIGN_DEF");
  IElementType ASSIGN_DESTRUCT = new KeyElementType("ASSIGN_DESTRUCT");
  IElementType ASSIGN_SINGLE = new KeyElementType("ASSIGN_SINGLE");
  IElementType ASSIGN_TO = new KeyElementType("ASSIGN_TO");
  IElementType CONST_STATEMENT = new KeyElementType("CONST_STATEMENT");
  IElementType EXPR = new KeyElementType("EXPR");
  IElementType IDENTIFIER = new KeyElementType("IDENTIFIER");
  IElementType LET_STATEMENT = new KeyElementType("LET_STATEMENT");
  IElementType STATEMENT = new KeyElementType("STATEMENT");
  IElementType VARIANT_EXPR = new KeyElementType("VARIANT_EXPR");

  IElementType AND = new KeyTokenType("&");
  IElementType ANDAND = new KeyTokenType("&&");
  IElementType ANDEQ = new KeyTokenType("&=");
  IElementType ARROW = new KeyTokenType("->");
  IElementType AT = new KeyTokenType("@");
  IElementType COLON = new KeyTokenType(":");
  IElementType COLONCOLON = new KeyTokenType("::");
  IElementType COMMA = new KeyTokenType(",");
  IElementType COMMENT = new KeyTokenType("COMMENT");
  IElementType CONST = new KeyTokenType("CONST");
  IElementType DIV = new KeyTokenType("/");
  IElementType DIVEQ = new KeyTokenType("/=");
  IElementType DOLLAR = new KeyTokenType("$");
  IElementType DOT = new KeyTokenType(".");
  IElementType DOTDOT = new KeyTokenType("..");
  IElementType DOTDOTDOT = new KeyTokenType("...");
  IElementType DOTDOTEQ = new KeyTokenType("..=");
  IElementType EQ = new KeyTokenType("=");
  IElementType EQEQ = new KeyTokenType("==");
  IElementType EXCL = new KeyTokenType("!");
  IElementType EXCLEQ = new KeyTokenType("!=");
  IElementType FAT_ARROW = new KeyTokenType("=>");
  IElementType GT = new KeyTokenType(">");
  IElementType ID = new KeyTokenType("ID");
  IElementType INTEGER_LITERAL = new KeyTokenType("INTEGER_LITERAL");
  IElementType LBRACE = new KeyTokenType("{");
  IElementType LBRACK = new KeyTokenType("[");
  IElementType LET = new KeyTokenType("LET");
  IElementType LPAREN = new KeyTokenType("(");
  IElementType LT = new KeyTokenType("<");
  IElementType MINUS = new KeyTokenType("-");
  IElementType MINUSEQ = new KeyTokenType("-=");
  IElementType MUL = new KeyTokenType("*");
  IElementType MULEQ = new KeyTokenType("*=");
  IElementType OR = new KeyTokenType("|");
  IElementType OREQ = new KeyTokenType("|=");
  IElementType PIPE = new KeyTokenType("|>");
  IElementType PLUS = new KeyTokenType("+");
  IElementType PLUSEQ = new KeyTokenType("+=");
  IElementType Q = new KeyTokenType("?");
  IElementType RBRACE = new KeyTokenType("}");
  IElementType RBRACK = new KeyTokenType("]");
  IElementType REM = new KeyTokenType("%");
  IElementType REMEQ = new KeyTokenType("%=");
  IElementType RPAREN = new KeyTokenType(")");
  IElementType SEMICOLON = new KeyTokenType(";");
  IElementType SHA = new KeyTokenType("#");
  IElementType STRING_LITERAL = new KeyTokenType("STRING_LITERAL");
  IElementType T = new KeyTokenType("~");
  IElementType UNDERSCORE = new KeyTokenType("_");
  IElementType XOR = new KeyTokenType("^");
  IElementType XOREQ = new KeyTokenType("^=");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGN_DEF) {
        return new KeyAssignDefImpl(node);
      }
      else if (type == ASSIGN_DESTRUCT) {
        return new KeyAssignDestructImpl(node);
      }
      else if (type == ASSIGN_SINGLE) {
        return new KeyAssignSingleImpl(node);
      }
      else if (type == ASSIGN_TO) {
        return new KeyAssignToImpl(node);
      }
      else if (type == CONST_STATEMENT) {
        return new KeyConstStatementImpl(node);
      }
      else if (type == EXPR) {
        return new KeyExprImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new KeyIdentifierImpl(node);
      }
      else if (type == LET_STATEMENT) {
        return new KeyLetStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new KeyStatementImpl(node);
      }
      else if (type == VARIANT_EXPR) {
        return new KeyVariantExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
