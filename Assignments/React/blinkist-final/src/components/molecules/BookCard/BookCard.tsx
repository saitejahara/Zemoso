import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";

import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";

import Button from "../../atoms/Button/Button";
import TimeIcon from "@material-ui/icons/AccessTime";
import { ListItem, ListItemIcon, ListItemText } from "@material-ui/core";

import TypographyComponent from "../../atoms/Typography/Typography";

const BookCard = (props: any) => {
  const useStyles = makeStyles({
    root: {
      maxWidth: 345,
      padding: "none",
    },
    icon: {
      paddingRight: "0px",
      minWidth: 5,
    },
    button: {
      fontFamily: "CeraPRO-BOLD",
      fontSize: "1.2rem",
      textTransform: "none",
      backgroundColor: "#76ff64",
      padding: "none",
    },
    cardMedia: {
      marginBottom: "20px",
    },
  });

  const classes = useStyles();
  return (
    <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          className={classes.cardMedia}
          component="img"
          image={props.image}
        />
        <CardContent>
          <TypographyComponent
            gutterBottom
            variant="h5"
            component="h2"
            name={props.title}
          >
            {props.title}
          </TypographyComponent>
          <TypographyComponent
            variant="body2"
            color="textSecondary"
            component="p"
            name={props.author}
          >
            {props.author}
          </TypographyComponent>
          <ListItem>
            <ListItemIcon className={classes.icon}>
              <TimeIcon />
            </ListItemIcon>
            <ListItemText>{props.time} minute read</ListItemText>
          </ListItem>
        </CardContent>
      </CardActionArea>

      <CardActions style={{ padding: "0" }}>
        <Button
          name={props.name}
          className={classes.button}
          fullWidth
          variant="contained"
          backgroundColor="#76ff64"
          onClick={props.onClick}
          disabled={props.disabled}
        ></Button>
      </CardActions>
    </Card>
  );
};

export default BookCard;
