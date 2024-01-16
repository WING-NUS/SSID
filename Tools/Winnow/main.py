from plagDetector import PlagDetector
from . import __version__
import numpy as np
import os
import sys
import json
import argparse

def main():

    # parser options
    parser = argparse.ArgumentParser(description="Winnow")
    parser.add_argument("--e", help="Extensions")
    parser.add_argument("--s", help="Skeleton Directories")
    parser.add_argument("--n", default=10, type=int, help="Minimum no of matching chars to be considered")
    parser.add_argument("--g", default=10, type=int, help="Minimum no of matching chars guaranteed as copied")
    parser.add_argument("--d", default=0.50, type=float, help="Display threshold")
    args = parser.parse_args()

    config = {
        "extensions": args.e, 
        "skeleton_dir": args.s,
        "noise_value": args.n,
        "guarantee_value": args.g,
        "display_thres": args.d
    }
    
    # run winnow algorithm
    plagDetector = PlagDetector(config)
    plagDetector.run()

if __name__ == "__main__":
    main()
