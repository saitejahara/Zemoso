import React from "react";
import { useAuth0 } from "@auth0/auth0-react";
import { Button } from "@material-ui/core";

const LoginButton = () => {
  const { loginWithRedirect, isAuthenticated } = useAuth0();

  const loggedIn = isAuthenticated;

  if (!loggedIn) {
    return (
      <Button
        onClick={() => loginWithRedirect()}
        style={{
          textTransform: "capitalize",
          fontSize: "medium",
          paddingLeft: 20,
        }}
        // color="secondary"
      >
        Login
      </Button>
    );
  } else {
    return <div></div>;
  }
};

export default LoginButton;
