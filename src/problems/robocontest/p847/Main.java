package problems.robocontest.p847;

import java.util.Arrays;
import java.util.Scanner;

enum PieceType {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING
}

abstract class Piece {
    PieceType type;
    boolean isWhite;

    public Piece(PieceType type, boolean isWhite) {
        this.type = type;
        this.isWhite = isWhite;
    }

    abstract boolean canMove(Piece[][] pieces, int fromX, int fromY, int toX, int toY);

//    public static Piece fromChar(char ch) {
//        return switch (ch) {
//            case 'p' -> new Pawn(false);
//            case 'P' -> new Pawn(true);
//            case 'n' -> new Knight(false);
//            case 'N' -> new Knight(true);
//            case 'b' -> new Bishop(false);
//            case 'B' -> new Bishop(true);
//            case 'r' -> new Rook(false);
//            case 'R' -> new Rook(true);
//            case 'q' -> new Queen(false);
//            case 'Q' -> new Queen(true);
//            case 'k' -> new King(false);
//            case 'K' -> new King(true);
//            default -> null;
//        };
//    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                ", isWhite=" + isWhite +
                '}';
    }
}

class Pawn extends Piece {

    public Pawn(boolean isWhite) {
        super(PieceType.PAWN, isWhite);
    }

    @Override
    public boolean canMove(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        if (isWhite) {
            if (fromX == toX) {
                return fromY == 1 && toY == 3 || toY - fromY == 1;
            } else if (Math.abs(fromX - toX) == 1 && toY - fromY == 1) {
                return pieces[toX][toY] != null && !pieces[toX][toY].isWhite;
            }
        } else {
            if (fromX == toX) {
                return fromY == 6 && toY == 4 || fromY - toY == 1;
            } else if (Math.abs(fromX - toX) == 1 && fromY - toY == 1) {
                return pieces[toX][toY] != null && pieces[toX][toY].isWhite;
            }
        }
        return false;
    }
}

class Knight extends Piece {
    int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public Knight(boolean isWhite) {
        super(PieceType.KNIGHT, isWhite);
    }

    @Override
    public boolean canMove(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        for (int[] move : moves) {
            int x = fromX + move[0];
            int y = fromY + move[1];
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (x == toX && y == toY) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Bishop extends Piece {
    int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public Bishop(boolean isWhite) {
        super(PieceType.BISHOP, isWhite);
    }

    @Override
    public boolean canMove(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        for (int[] direction : directions) {
            int x = fromX + direction[0];
            int y = fromY + direction[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (x == toX && y == toY) {
                    return true;
                }

                x += direction[0];
                y += direction[1];
            }
        }
        return false;
    }
}

class Rook extends Piece {
    int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    public Rook(boolean isWhite) {
        super(PieceType.ROOK, isWhite);
    }

    @Override
    public boolean canMove(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        for (int[] direction : directions) {
            int x = fromX + direction[0];
            int y = fromY + direction[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (x == toX && y == toY) {
                    return true;
                }

                x += direction[0];
                y += direction[1];
            }
        }
        return false;
    }
}


class Queen extends Piece {
    int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public Queen(boolean isWhite) {
        super(PieceType.QUEEN, isWhite);
    }

    @Override
    public boolean canMove(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        for (int[] direction : directions) {
            int x = fromX + direction[0];
            int y = fromY + direction[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (x == toX && y == toY) {
                    return true;
                }

                x += direction[0];
                y += direction[1];
            }
        }
        return false;
    }
}

class King extends Piece {
    int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public King(boolean isWhite) {
        super(PieceType.KING, isWhite);
    }

    @Override
    public boolean canMove(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        for (int[] direction : directions) {
            int x = fromX + direction[0];
            int y = fromY + direction[1];
            if (x >= 0 && x < 8 && y >= 0 && y < 8 && x == toX && y == toY) {
                return true;
            }
        }
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean moveIsWhite = in.nextInt() == 1;
        Piece[][] pieces = new Piece[8][8];
        for (int i = 7; i >= 0; i--) {
            char[] chars = in.next().toCharArray();
            for (int j = 0; j < 8; j++) {
//                pieces[i][j] = Piece.fromChar(chars[i]);
            }
        }

        System.out.println(Arrays.deepToString(pieces));

    }
}


