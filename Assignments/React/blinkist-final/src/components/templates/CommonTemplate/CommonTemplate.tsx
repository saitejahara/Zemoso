import React from "react";
import {
  makeStyles,
  Box,
  Grid,
  Container,
  Typography,
  Button,
} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  header: {
    marginBottom: "4rem",
  },
  paperTitle: {
    color: "red",
  },
  paperSubtitle: {
    fontWeight: "bold",
  },
  paper: {
    textAlign: "center",
    "& > *": {
      backgroundColor: "#ecf2fb",
      padding: theme.spacing(1),
      height: theme.spacing(16),
      width: "fit-content",
    },
  },
  btn: {
    color: "limegreen",
  },
  heading: {
    marginBottom: "2rem",
    marginTop: "6rem",
  },
}));

const CommonTemplate = (props: any) => {
  const styles = useStyles();
  const { header, mainContent, pageName } = props;
  console.log(pageName);
  return (
    <>
      <Container maxWidth="md">
        <Box>{header}</Box>
        <br />
        {mainContent}
      </Container>
    </>
  );
};

export default CommonTemplate;
