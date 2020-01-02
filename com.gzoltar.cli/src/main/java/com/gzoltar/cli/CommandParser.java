/**
 * Copyright (C) 2020 GZoltar contributors.
 * 
 * This file is part of GZoltar.
 * 
 * GZoltar is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * GZoltar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with GZoltar. If
 * not, see <https://www.gnu.org/licenses/>.
 */
package com.gzoltar.cli;

import org.kohsuke.args4j.CmdLineParser;

/**
 * Parser which remembers the parsed command to have additional context information to produce help
 * output.
 * 
 * DISCLAIMER: this class has been exported from JaCoCo's cli module for convenience.
 */
public class CommandParser extends CmdLineParser {

  private final Command command;

  public CommandParser(final Command command) {
    super(command);
    this.command = command;
  }

  public Command getCommand() {
    return command;
  }
}
