package com.myApp.web.game.logic.moveCalc.pieces;

import com.myApp.web.game.Move;
import com.myApp.web.game.logic.moveCalc.MoveCalc;
import com.myApp.web.game.physics.SquareLocation;
import com.myApp.web.game.physics.SquareLocationNavigator;
import com.myApp.web.game.physics.Vector;
import com.myApp.web.game.utils.Player;
import com.myApp.web.game.utils.SquareStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PawnMoveCalc implements MoveCalc {
    private final List<Vector> moveVectors;
    private final List<Vector> captureVectors;


    public PawnMoveCalc(Player owner, boolean hasMoved) {
        moveVectors = new ArrayList<>();
        captureVectors = new ArrayList<>();
        if (owner.equals(Player.WHITE)) {
            moveVectors.add(new Vector(1, 0));
            if (!hasMoved) {
                moveVectors.add(new Vector(2, 0));
            }
            captureVectors.add(new Vector(1, 1));
            captureVectors.add(new Vector(1, -1));
        } else {
            moveVectors.add(new Vector(-1, 0));
            if (!hasMoved) {
                moveVectors.add(new Vector(-2, 0));
            }
            captureVectors.add(new Vector(-1, 1));
            captureVectors.add(new Vector(-1, -1));
        }
    }

    @Override
    public List<Move> getPossibleMoves(SquareLocation pieceLocation, Map<SquareLocation, SquareStatus> locationStatusMap) {
        List<Move> possibleMoves = new ArrayList<>();
        for (Vector moveVector : moveVectors) {
            SquareLocation moveLocation = SquareLocationNavigator.applyVectorToSquareLocation(pieceLocation, moveVector);
            SquareStatus status = locationStatusMap.get(moveLocation);
            if (status == SquareStatus.EMPTY) {
                Move move = new Move(pieceLocation.getX(), pieceLocation.getY(), moveLocation.getX(), moveLocation.getY());
                possibleMoves.add(move);
            } else {
                break;
            }
        }
        for (Vector captureVector : captureVectors) {
            SquareLocation captureLocation = SquareLocationNavigator.applyVectorToSquareLocation(pieceLocation, captureVector);
            SquareStatus status = locationStatusMap.get(captureLocation);
            if (status == SquareStatus.ENEMY) {
                Move move = new Move(pieceLocation.getX(), pieceLocation.getY(), captureLocation.getX(), captureLocation.getY());
                possibleMoves.add(move);
            }
        }
        return possibleMoves;
    }

    public boolean pawnCanBePromoted(SquareLocation pieceLocation, Map<SquareLocation, SquareStatus> locationStatusMap) {
        Vector moveVector = moveVectors.get(0);
        SquareLocation moveLocation = SquareLocationNavigator.applyVectorToSquareLocation(pieceLocation, moveVector);
        return !locationStatusMap.containsKey(moveLocation);
    }
}