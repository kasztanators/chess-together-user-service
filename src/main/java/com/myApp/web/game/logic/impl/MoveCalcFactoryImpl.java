package com.myApp.web.game.logic.impl;

import com.myApp.web.game.Piece;
import com.myApp.web.game.logic.MoveCalc;
import com.myApp.web.game.logic.MoveCalcFactory;
import com.myApp.web.game.logic.impl.moveCalc.pieces.*;
import com.myApp.web.game.utils.Type;
import org.springframework.stereotype.Component;

import static com.myApp.web.game.utils.Type.*;

@Component("moveCalculatorFactoryImpl")
public class MoveCalcFactoryImpl implements MoveCalcFactory {

    @Override
    public MoveCalc buildMoveCalculator(Piece piece) {
        if (piece == null) {
            throw new RuntimeException("A null piece was passed to MoveCalculatorFactoryImpl.buildMoveCalculator(piece)");
        }
        Type type = piece.getType();
        if (type.equals(PAWN)) {
            //Pawns need to know the owner and if it is a virgin pawn
            return new PawnMoveCalc(piece.getOwner(), piece.isHasMoved());
            //Other pieces move without regard to owner or previous move status
        } else if (type.equals(ROOK)) {
            return new RookMoveCalc();
        } else if (type.equals(KNIGHT)) {
            return new KnightMoveCalc();
        } else if (type.equals(BISHOP)) {
            return new BishopMoveCalc();
        } else if (type.equals(KING)) {
            return new KingMoveCalc();
        } else if (type.equals(QUEEN)) {
            return new QueenMoveCalc();
        } else {
            throw new RuntimeException("The following piece type was not found: " + type);
        }
    }
}
