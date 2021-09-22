import "./Header.css";
import "bootstrap/dist/css/bootstrap.css";
import { Nav, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
// import Explore from "../ExploreContent/ExploreContent";
import AddIcon from "@material-ui/icons/Add";
import logo from "../../../assets/images/Blinkist_logo2.png";
// import MyLibrary from "../MyLibraryContent/MyLibraryContent";
import AddBook from "../../molecules/AddBook/AddBook";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import ExpandLessIcon from "@material-ui/icons/ExpandLess";
import { useAuth0 } from "@auth0/auth0-react";
import LoginButton from "../../services/Authentication/LoginButton/LoginButton";
import LogoutButton from "../../services/Authentication/LogoutButton/LogoutButton";
import Collapse from "@material-ui/core/Collapse";
import ExploreDropDown from "../../molecules/ExploreDropDown/ExploreDropDown";
import { useState } from "react";
import {
  alpha,
  IconButton,
  Menu,
  MenuItem,
  MenuProps,
  styled,
} from "@material-ui/core";
import { LibraryBooks } from "@material-ui/icons";

const StyledMenu = styled((props: MenuProps) => (
  <Menu
    elevation={0}
    anchorOrigin={{
      vertical: "bottom",
      horizontal: "right",
    }}
    transformOrigin={{
      vertical: "top",
      horizontal: "right",
    }}
    {...props}
  />
))(({ theme }) => ({
  "& .MuiPaper-root": {
    borderRadius: 6,
    marginTop: theme.spacing(1),
    minWidth: 180,
    color: "rgb(55, 65, 81)",
    boxShadow:
      "rgb(255, 255, 255) 0px 0px 0px 0px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px, rgba(0, 0, 0, 0.1) 0px 10px 15px -3px, rgba(0, 0, 0, 0.05) 0px 4px 6px -2px",
    "& .MuiMenu-list": {
      padding: "4px 0",
    },
    "& .MuiMenuItem-root": {
      "& .MuiSvgIcon-root": {
        fontSize: 18,
        color: theme.palette.text.secondary,
        marginRight: theme.spacing(1.5),
      },
      "&:active": {
        backgroundColor: alpha(
          theme.palette.primary.main,
          theme.palette.action.selectedOpacity
        ),
      },
    },
  },
}));

const Header: React.FC<{}> = () => {
  const { isAuthenticated } = useAuth0();

  const [expanded, setExpanded] = useState(false);

  const [show, setShow] = useState(false);

  const handleShow = () => {
    console.log(show);
    setShow(!show);
  };

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  const handleClick = () => {
    console.log("clicked");
  };

  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);
  const handleAccountClick = (event: any) => {
    setAnchorEl(event.currentTarget);
  };
  const handleAccountClose = (event: any) => {
    setAnchorEl(null);
  };

  //   const addBookClick = () => {};
  return (
    // <Router>
    <div>
      <Navbar
        className="navbar-nav mx-auto "
        bg="myRed"
        collapseOnSelect
        fixed="top"
        expand="sm"
      >
        {/* <Navbar.Toggle /> */}
        <Navbar.Collapse>
          <Nav.Link as={Link} to={"/"}>
            <img
              className="navitem"
              src={logo}
              alt="logo"
              width="220"
              height="115"
            ></img>
          </Nav.Link>

          <Nav className="ml-auto">
            <Nav.Link>
              <IconButton
                onClick={handleExpandClick}
                aria-expanded={expanded}
                aria-label="show more"
                className="expandButton"
              >
                Explore
                {expanded !== true ? <ExpandMoreIcon /> : <ExpandLessIcon />}
              </IconButton>
            </Nav.Link>

            <Nav.Link as={Link} to="/library">
              <IconButton className="navitem">
                My Library
                <LibraryBooks />
              </IconButton>
            </Nav.Link>

            <Nav.Link as={Link} to="/explore">
              <IconButton onClick={handleShow} className="navitem">
                Add Book
                <AddIcon />
              </IconButton>
            </Nav.Link>

            <Nav.Link>
              <IconButton
                id="demo-customized-button"
                aria-controls="demo-customized-menu"
                aria-haspopup="true"
                aria-expanded={open ? "true" : undefined}
                onClick={handleAccountClick}
                className="expandButton navitem"
              >
                Account
                <ExpandMoreIcon />
              </IconButton>
            </Nav.Link>
            <StyledMenu
              id="demo-customized-menu"
              MenuListProps={{
                "aria-labelledby": "demo-customized-button",
              }}
              anchorEl={anchorEl}
              open={open}
              onClose={handleAccountClose}
            >
              <MenuItem onClick={handleAccountClose} disableRipple>
                HighLights
              </MenuItem>
              <MenuItem onClick={handleAccountClose} disableRipple>
                Invite Friends
              </MenuItem>
              {/* <Divider /> */}
              <MenuItem onClick={handleAccountClose} disableRipple>
                Wish List
              </MenuItem>
              <MenuItem onClick={handleAccountClose} disableRipple>
                Settings
              </MenuItem>
              <MenuItem onClick={handleAccountClose} disableRipple>
                <LoginButton />
                <LogoutButton />
              </MenuItem>
            </StyledMenu>

            <div className="navitem">
              {show == true ? <AddBook show={true} /> : <></>}
            </div>
          </Nav>
        </Navbar.Collapse>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <ExploreDropDown />
        </Collapse>
      </Navbar>

      {/* <Switch>
          <Route path="/explore">
            <div style={{ height: 130 }}></div>
            <Explore />
          </Route>
          {isAuthenticated === true ? (
            <Route path="/library">
              <div style={{ height: 130 }}></div>
              <MyLibrary />
            </Route>
          ) : (
            <></>
          )}
        </Switch> */}
    </div>
    // </Router>
  );
};

export default Header;
