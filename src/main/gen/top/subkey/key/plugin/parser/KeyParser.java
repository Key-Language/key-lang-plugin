// This is a generated file. Not intended for manual editing.
package top.subkey.key.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static top.subkey.key.plugin.psi.KeyTypes.*;
import static top.subkey.key.plugin.parser.KeyParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class KeyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return keyFile(b, l + 1);
  }

  /* ********************************************************** */
  // assign_to ('<' | '=') expr
  public static boolean assign_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_def")) return false;
    if (!nextTokenIs(b, "<assign def>", ID, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_DEF, "<assign def>");
    r = assign_to(b, l + 1);
    r = r && assign_def_1(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '<' | '='
  private static boolean assign_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_def_1")) return false;
    boolean r;
    r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, EQ);
    return r;
  }

  /* ********************************************************** */
  // '[' identifiers ']'
  public static boolean assign_destruct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_destruct")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && identifiers(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, ASSIGN_DESTRUCT, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean assign_single(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_single")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, ASSIGN_SINGLE, r);
    return r;
  }

  /* ********************************************************** */
  // assign_single | assign_destruct
  public static boolean assign_to(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_to")) return false;
    if (!nextTokenIs(b, "<assign to>", ID, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_TO, "<assign to>");
    r = assign_single(b, l + 1);
    if (!r) r = assign_destruct(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' statements '}'
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && statements(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // CONST assign_def
  public static boolean const_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_statement")) return false;
    if (!nextTokenIs(b, CONST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONST);
    r = r && assign_def(b, l + 1);
    exit_section_(b, m, CONST_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // variant_expr |
  //     INTEGER_LITERAL |
  //     STRING_LITERAL
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = variant_expr(b, l + 1);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier '(' ')' (statement | block)
  public static boolean func_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeTokens(b, 0, LPAREN, RPAREN);
    r = r && func_def_3(b, l + 1);
    exit_section_(b, m, FUNC_DEF, r);
    return r;
  }

  // statement | block
  private static boolean func_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def_3")) return false;
    boolean r;
    r = statement(b, l + 1);
    if (!r) r = block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // (identifier ',')* (identifier ','?)
  public static boolean identifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifiers_0(b, l + 1);
    r = r && identifiers_1(b, l + 1);
    exit_section_(b, m, IDENTIFIERS, r);
    return r;
  }

  // (identifier ',')*
  private static boolean identifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifiers_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifiers_0", c)) break;
    }
    return true;
  }

  // identifier ','
  private static boolean identifiers_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier ','?
  private static boolean identifiers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && identifiers_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean identifiers_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers_1_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // statements
  static boolean keyFile(PsiBuilder b, int l) {
    return statements(b, l + 1);
  }

  /* ********************************************************** */
  // LET (assign_def | func_def)
  public static boolean let_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && let_statement_1(b, l + 1);
    exit_section_(b, m, LET_STATEMENT, r);
    return r;
  }

  // assign_def | func_def
  private static boolean let_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_1")) return false;
    boolean r;
    r = assign_def(b, l + 1);
    if (!r) r = func_def(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // CONST '(' identifier ')'
  public static boolean lock_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lock_statement")) return false;
    if (!nextTokenIs(b, CONST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONST, LPAREN);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, LOCK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // let_statement |
  //     const_statement |
  //     lock_statement |
  //     block |
  //     expr
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = let_statement(b, l + 1);
    if (!r) r = const_statement(b, l + 1);
    if (!r) r = lock_statement(b, l + 1);
    if (!r) r = block(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (statement ';'? | COMMENT)*
  public static boolean statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements")) return false;
    Marker m = enter_section_(b, l, _NONE_, STATEMENTS, "<statements>");
    while (true) {
      int c = current_position_(b);
      if (!statements_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statements", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // statement ';'? | COMMENT
  private static boolean statements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statements_0_0(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement ';'?
  private static boolean statements_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && statements_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean statements_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_0_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean variant_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, VARIANT_EXPR, r);
    return r;
  }

}
