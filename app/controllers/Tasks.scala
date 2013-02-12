package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Task

object Tasks extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def index = Action{
    Ok(views.html.tasks.index(Task.all(), taskForm))

  }

  def create = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.tasks.index(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Tasks.index)
      }
    )
  }

  def destroy(id: Long) = Action {
    Task.destroy(id)
    Redirect(routes.Tasks.index)
  }

}