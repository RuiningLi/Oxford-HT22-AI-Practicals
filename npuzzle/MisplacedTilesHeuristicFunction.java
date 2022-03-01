package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    @Override
    public int getValue(Node n) {
        Tiles tiles = (Tiles)n.state;
        int numTiles = tiles.width * tiles.width - 1;
        int numMisplacedTiles = 0;
        for (int index = 0; index <= numTiles; index++) {
            if (tiles.tiles[index] != 0 && tiles.tiles[index] != (index + 1) % (numTiles + 1)) {
                numMisplacedTiles++;
            }
        }
        return numMisplacedTiles;
    }
}
